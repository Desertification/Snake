package mybase;

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
        LinkedList<Point> snakeBody = snake.getBody();
        Direction direction = snake.getDirection();

        Point head = snakeBody.first();
        Point nextCoordinates = Navigation.getNextPoint(head, direction);

        int snakeLength = snakeBody.size();
        for (int i = 0; i < snakeLength; i++) {
            Point snakeBodyPart = snakeBody.first();
            Point copyOfOldCoordinates = new Point(snakeBodyPart);
            snakeBodyPart.set(nextCoordinates);
            nextCoordinates = copyOfOldCoordinates;
            snakeBody = snakeBody.tail();
        }

        warpIfNeeded();
    }

    private void warpIfNeeded() {
        LinkedList<Point> snakeBody = snake.getBody();

        Point head = snakeBody.first();
        if (Navigation.isOutOfBounds(head, game.getBounds())) {
            Navigation.warp(head, game.getBounds());
        }
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
}
