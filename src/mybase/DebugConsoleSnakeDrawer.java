package mybase;

/**
 * Created by thoma on 11-Mar-17.
 */
public class DebugConsoleSnakeDrawer extends ConsoleSnakeDrawer {
    public DebugConsoleSnakeDrawer(ConsoleFrameDrawer consoleFrameDrawer) {
        super(consoleFrameDrawer);
    }

    @Override
    protected char getBodyCharacterFor(int index) {
        return intToChar(index);
    }

    private char intToChar(int index) {
        return (char) (index + 48);
    }
}
