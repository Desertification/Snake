package mybase;

import myLinkedList.Iterator;
import myLinkedList.LinkedList;

import java.util.Random;

/**
 * Created by thoma on 11-Mar-17.
 */
public class Game implements Runnable {
    private Dimension bounds;
    private LinkedList<Entity> entities;
    private LinkedList<Entity> players;
    private ConsoleFrameDrawer frameDrawer;
    private EntityFactory entityFactory;
    private int targetDeltaTime = 100;
    private ConsoleKeySubject consoleKeySubject;
    private Random random;
    private LinkedList<Entity> deleteLater;

    public Game() {
        random = new Random();
        entities = new LinkedList<>();
        players = new LinkedList<>();
        deleteLater = new LinkedList<>();
        bounds = new Dimension(30, 15);
        frameDrawer = new ConsoleFrameDrawer(System.out, bounds);
        entityFactory = new EntityFactory(this);
        consoleKeySubject = new ConsoleKeySubject();
        Thread keySubjectThread = new Thread(consoleKeySubject, "consoleKeySubject");
        keySubjectThread.setDaemon(true);
        keySubjectThread.start();
    }

    public ConsoleFrameDrawer getFrameDrawer() {
        return frameDrawer;
    }

    public Dimension getBounds() {
        return bounds;
    }

    public void setBounds(Dimension bounds) {
        this.bounds = bounds;
    }

    public void loadLevel() {
        // todo implement level object (matrix of entitytypes?)
        bounds = new Dimension(30, 15); // todo get from level
        entities = new LinkedList<>();
        players = new LinkedList<>();
        frameDrawer = new ConsoleFrameDrawer(System.out, bounds);
        // todo actual loading
    }

    public Entity spawnEntity(EntityType entity) {
        return spawnEntity(entity, getRandomPoint());
    }

    public Entity spawnEntity(EntityType entity, Point location) {
        return spawnEntity(entity, location, Direction.RIGHT);
    }

    public Entity spawnEntity(EntityType entity, Point location, Direction direction) {
        Entity createdEntity = entityFactory.create(entity, location, direction);
        entities.append(createdEntity);
        return createdEntity;
    }

    public void spawnPlayer(EntityType entity, Point location, Direction direction) {
        Entity createdEntity = spawnEntity(entity, location, direction);
        players.append(createdEntity);

        // todo keybinding manager
        KeyBinder upBind = new KeyBinder(KeyBindings.up);
        upBind.addCommand(() -> createdEntity.setDirection(Direction.UP));
        consoleKeySubject.registerObserver(upBind);

        KeyBinder downBind = new KeyBinder(KeyBindings.down);
        downBind.addCommand(() -> createdEntity.setDirection(Direction.DOWN));
        consoleKeySubject.registerObserver(downBind);

        KeyBinder leftBind = new KeyBinder(KeyBindings.left);
        leftBind.addCommand(() -> createdEntity.setDirection(Direction.LEFT));
        consoleKeySubject.registerObserver(leftBind);

        KeyBinder rightBind = new KeyBinder(KeyBindings.right);
        rightBind.addCommand(() -> createdEntity.setDirection(Direction.RIGHT));
        consoleKeySubject.registerObserver(rightBind);

        KeyBinder escBind = new KeyBinder(KeyBindings.esc);
        escBind.addCommand(() -> System.exit(0));
        consoleKeySubject.registerObserver(escBind);

    }

    protected boolean isGameOver() {
        return players.isEmpty();
    }

    public void deleteEntity(Entity entity) {
        if (isEntityAPlayer(entity)) {
            players.remove(entity);
            //todo undo keybinding
        }
        entities.remove(entity);
    }

    public void deleteEntityLater(Entity entity) {
        deleteLater.append(entity);
    }

    private void deleteNow() {
        Iterator<Entity> iterator = deleteLater.iterator();
        while (iterator.hasNext()) {
            deleteEntity(iterator.next());
        }
        deleteLater = new LinkedList<>();
    }

    protected boolean isEntityAPlayer(Entity entity) {
        Iterator<Entity> iterator = players.iterator();
        while (iterator.hasNext()) {
            Entity next = iterator.next();
            if (next == entity) {
                return true;
            }
        }
        return false;
    }

    public void handleCollision(Entity entity) {
        Hitbox entityHitbox = entity.getHitbox();
        Iterator<Entity> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Entity next = iterator.next();
            boolean collidingWith = entityHitbox.isCollidingWith(next.getHitbox());
            if (collidingWith) {
                next.collideWith(entity.getCollisionBehavior());
            }
        }
    }

    public Point getRandomPoint() {
        int x = random.nextInt(bounds.width);
        int y = random.nextInt(bounds.height);
        return new Point(x, y);
    }

    public void exit() {
        System.exit(0);
    }

    @Override
    public void run() { // todo needs refactoring
        while (true) {
            long begin = System.nanoTime();
            Iterator<Entity> iterator = entities.iterator();
            while (iterator.hasNext()) {
                Entity entity = iterator.next();
                entity.move();
                handleCollision(entity);
                entity.draw();
            }
            deleteNow();
            frameDrawer.drawFrame();
            frameDrawer.clearFrame();

            if (isGameOver()) {
                break;
            }

            long delta = targetDeltaTime - ((System.nanoTime() - begin) / 1000000);
            try {
                Thread.sleep(Math.max(0, delta));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
