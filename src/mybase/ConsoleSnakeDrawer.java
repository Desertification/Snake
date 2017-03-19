package mybase;

/**
 * Created by thoma on 08-Mar-17.
 */
public class ConsoleSnakeDrawer extends ConsoleEntityDrawer {

    public ConsoleSnakeDrawer(Entity entity, ConsoleFrameDrawer consoleFrameDrawer) {
        super(entity, consoleFrameDrawer);
    }

    protected char getBodyCharacterFor(int index) {
        return '\u2592';
    }
}