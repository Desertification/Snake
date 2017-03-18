package mybase;

import myLinkedList.Iterator;
import myLinkedList.LinkedList;

/**
 * Created by thoma on 11-Mar-17.
 */
public class MoveBehavior implements Movable {
    private Entity entity;
    private Game game;

    public MoveBehavior(Game game) {
        this.game = game;
    }

    public void move() {
        LinkedList<Location> snakeBody = entity.getBody();
        Direction direction = entity.getDirection();

        Location head = snakeBody.first();
        Point nextPoint = Navigation.getNextPoint(new Point(head), direction);

        Iterator<Location> iterator = snakeBody.iterator();
        while (iterator.hasNext()) {
            Location location = iterator.next();
            Point copyOfOldCoordinates = new Point(location);
            location.set(nextPoint);
            nextPoint = copyOfOldCoordinates;
        }
        Point warpedPoint = Navigation.warp(new Point(head), game.getBounds());
        head.set(warpedPoint);
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
