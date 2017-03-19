package mybase;

import myLinkedList.LinkedList;

public class Snake extends Entity {

    Snake() {
        super();
        HeadFirstHitbox hitbox = new HeadFirstHitbox();
        hitbox.setBody(getBody()); // todo delegate to builder or not?
        super.setHitbox(hitbox);
    }

    public void grow() {
        LinkedList<Location> body = getBody();
        body.append(new Location(body.last()));
    }

    public void setDirection(Direction direction) {
        Direction currentDirection = getDirection();
        if (currentDirection != direction.opposite()) {
            super.setDirection(direction);
        }
    }

    @Override
    public void collideWith(CollisionBehavior collisionBehavior) {
        collisionBehavior.collideWith(this);
    }

}