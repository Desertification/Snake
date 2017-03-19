package mybase;

import myLinkedList.LinkedList;

/**
 * Created by thoma on 18-Mar-17.
 */
public abstract class Entity implements Drawable, Movable, Collidable {
    private LinkedList<Location> body;
    private Direction direction;
    private Hitbox hitbox;
    private Movable moveBehavior;
    private Drawable drawBehavior;
    private CollisionBehavior collisionBehavior;

    public Entity() {
        this(Direction.RIGHT, new Point(0, 0), new Hitbox());
    }

    public Entity(Direction direction, Point location) {
        this(direction, location, new Hitbox());
    }

    protected Entity(Direction direction, Point location, Hitbox hitbox) {
        this.direction = direction;
        body = new LinkedList<>(new Location(location));
        hitbox.setBody(body);
        this.hitbox = hitbox;
    }

    public void setLocation(Point location) {
        Location currentLocation = body.first();
        currentLocation.set(location);
    }

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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setMoveBehavior(Movable moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public void setDrawBehavior(Drawable drawBehavior) {
        this.drawBehavior = drawBehavior;
    }

    @Override
    public CollisionBehavior getCollisionBehavior() {
        return collisionBehavior;
    }

    public void setCollisionBehavior(CollisionBehavior collisionBehavior) {
        this.collisionBehavior = collisionBehavior;
    }

    @Override
    public abstract void collideWith(CollisionBehavior collisionBehavior);

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }
}
