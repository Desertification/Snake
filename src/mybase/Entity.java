package mybase;

import myLinkedList.LinkedList;

/**
 * Created by thoma on 18-Mar-17.
 */
public class Entity implements Drawable, Movable, Collidable {
    private LinkedList<Location> body;
    private Direction direction;
    private Hitbox hitbox;
    private Movable moveBehavior;
    private Drawable drawBehavior;
    private CollideBehavior collideBehavior;

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

    public void setCollideBehavior(CollideBehavior collideBehavior) {
        this.collideBehavior = collideBehavior;
    }

    @Override
    public void collideWith(Collidable other) {
        collideBehavior.collideWith(other);
    }

    @Override
    public void collideWith(Snake snake) {
        collideBehavior.collideWith(snake);
    }

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }
}
