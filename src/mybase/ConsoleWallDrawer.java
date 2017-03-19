package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public class ConsoleWallDrawer extends ConsoleEntityDrawer {
    public ConsoleWallDrawer(Entity entity, ConsoleFrameDrawer consoleFrameDrawer) {
        super(entity, consoleFrameDrawer);
    }

    @Override
    protected char getBodyCharacterFor(int i) {
        return '\u2588';
    }
}
