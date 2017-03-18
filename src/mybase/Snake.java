package mybase;

import myLinkedList.LinkedList;

public class Snake extends Entity {

    Snake() {
        super(Direction.RIGHT, new Point(0, 0), new SnakeHitbox());
    }

    public Snake(Direction direction, Point location) {
        super(direction, location, new SnakeHitbox());
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

}