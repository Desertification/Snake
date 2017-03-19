package mybase;

/**
 * Created by thoma on 19-Mar-17.
 */
public class ConsoleFoodDrawer extends ConsoleEntityDrawer {
    boolean toggle;

    public ConsoleFoodDrawer(Entity entity, ConsoleFrameDrawer consoleFrameDrawer) {
        super(entity, consoleFrameDrawer);
    }

    @Override
    protected char getBodyCharacterFor(int i) {
        toggle = !toggle;
        if (toggle) {
            return 'o';
        } else {
            return 'O';
        }
    }
}
