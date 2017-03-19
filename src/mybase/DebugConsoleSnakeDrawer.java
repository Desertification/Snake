package mybase;

/**
 * Created by thoma on 11-Mar-17.
 */
public class DebugConsoleSnakeDrawer extends ConsoleSnakeDrawer {
    public DebugConsoleSnakeDrawer(Snake snake, ConsoleFrameDrawer consoleFrameDrawer) {
        super(snake, consoleFrameDrawer);
    }

    @Override
    protected char getBodyCharacterFor(int index) {
        return intToChar(index);
    }

    private char intToChar(int index) {
        return (char) (index + 48);
    }
}
