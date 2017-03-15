package mybase;

import myLinkedList.Iterator;
import myLinkedList.LinkedList;

/**
 * Created by thoma on 11-Mar-17.
 */
public class SnakeBehavior implements Updatable {
    private Snake snake;
    private Game game;

    public SnakeBehavior(Game game) {
        this.game = game;
    }

    @Override
    public void update() {
        move();
    }

    private void move() {
        LinkedList<Location> snakeBody = snake.getBody();
        Direction direction = snake.getDirection();

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

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
}
