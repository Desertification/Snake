package mybase;

import myLinkedList.LinkedList;

/**
 * Created by thoma on 18-Mar-17.
 * An abstract game entity
 * contains code shared by snakes,walls,food,...
 */
public abstract class Entity implements Drawable, Movable, Collidable {
    private LinkedList<Location> body;
    private Direction direction;
    private Hitbox hitbox;
    private Movable moveBehavior;
    private Drawable drawBehavior;
    private CollisionBehavior collisionBehavior;

    public Entity() {
        this.direction = direction;
        body = new LinkedList<>(new Location(0, 0));
        hitbox = new Hitbox();
        hitbox.setBody(body);
        this.hitbox = hitbox;
    }

    /**
     * @param location new location of the entity on the map
     */
    public void setLocation(Point location) {
        Location currentLocation = body.first();
        currentLocation.set(location);
    }

    /**
     * @return the linked list of locations of the body
     */
    public LinkedList<Location> getBody() {
        return body;
    }

    @Override
    public void draw() {
        drawBehavior.draw();
    }

    @Override
    public void move() {
        moveBehavior.move();
    }

    /**
     * @return the facing direction of the entity
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the facing direction of the entity
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @param moveBehavior object containing the logic on how the enmity should move
     */
    public void setMoveBehavior(Movable moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    /**
     * @param drawBehavior object containing the logic on how the entity should be drawn
     */
    public void setDrawBehavior(Drawable drawBehavior) {
        this.drawBehavior = drawBehavior;
    }

    @Override
    public CollisionBehavior getCollisionBehavior() {
        return collisionBehavior;
    }

    /**
     * @param collisionBehavior object containing the logic on how the entity should react when colliding with others
     */
    public void setCollisionBehavior(CollisionBehavior collisionBehavior) {
        this.collisionBehavior = collisionBehavior;
    }

    @Override
    public abstract void collideWith(CollisionBehavior collisionBehavior);

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }

    @Override
    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }
}
