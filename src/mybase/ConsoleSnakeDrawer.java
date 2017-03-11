package mybase;

import myLinkedList.LinkedList;

/**
 * Created by thoma on 08-Mar-17.
 */
public class ConsoleSnakeDrawer implements Drawable {
    private Snake snake;
    private ConsoleFrameDrawer consoleFrameDrawer;
    private char bodyCharacter = '\u2592';

    public ConsoleSnakeDrawer(ConsoleFrameDrawer consoleFrameDrawer) {
        this.consoleFrameDrawer = consoleFrameDrawer;
    }

    @Override
    public void draw() {
        ConsoleFrame frame = consoleFrameDrawer.getFrame();
        LinkedList<Point> body = snake.getBody();
        int snakeLength = body.size();
        for (int i = 0; i < snakeLength; i++) {
            frame.setCell(body.first(), getBodyCharacterFor(i));
            body = body.tail();
        }
    }

    protected char getBodyCharacterFor(int index) {
        return bodyCharacter;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
}
