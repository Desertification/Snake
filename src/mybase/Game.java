package mybase;

import myLinkedList.Iterator;
import myLinkedList.LinkedList;

/**
 * Created by thoma on 11-Mar-17.
 */
public class Game implements Runnable {
    private Dimension bounds;
    private LinkedList<Entity> entities;
    private LinkedList<Entity> players;
    private ConsoleFrameDrawer frameDrawer;
    private EntityCreator entityCreator;
    private int targetDeltaTime = 100;

    public Game() {
        entities = new LinkedList<>();
        players = new LinkedList<>();
        bounds = new Dimension(30, 15);
        frameDrawer = new ConsoleFrameDrawer(System.out, bounds);
        entityCreator = new EntityCreator(this);
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

    public void spawnEntity(EntityType entity, Point location, Direction direction) {
        //todo create with entity creator
    }

    public void spawnPlayer(EntityType entity, Point location, Direction direction) {
        spawnEntity(entity, location, direction);
        // todo keybind
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
            // todo is game over
            frameDrawer.drawFrame();
            frameDrawer.clearFrame();

            long delta = (System.nanoTime() - begin) / 1000000;
            try {
                Thread.sleep(Math.max(0, delta));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
