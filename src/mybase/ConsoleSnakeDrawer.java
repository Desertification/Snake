package mybase;

import myLinkedList.Iterator;
import myLinkedList.LinkedList;

/**
 * Created by thoma on 08-Mar-17.
 */
public class ConsoleSnakeDrawer implements Drawable {
    private Snake snake;
    private ConsoleFrameDrawer consoleFrameDrawer;
    private char bodyCharacter = '\u2592';

    public ConsoleSnakeDrawer(Snake snake, ConsoleFrameDrawer consoleFrameDrawer) {
        this.consoleFrameDrawer = consoleFrameDrawer;
        this.snake = snake;
    }

    @Override
    public void draw() {
        ConsoleFrame frame = consoleFrameDrawer.getFrame();
        LinkedList<Location> body = snake.getBody();

        int i = 0;
        Iterator<Location> iterator = body.iterator();
        while (iterator.hasNext()) {
            frame.setCell(new Point(iterator.next()), getBodyCharacterFor(i));
            i++;
        }
    }

    protected char getBodyCharacterFor(int index) {
        return bodyCharacter;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
}
