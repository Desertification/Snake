package mybase;

import myLinkedList.Iterator;
import myLinkedList.LinkedList;

/**
 * Created by thoma on 19-Mar-17.
 */
public class ConsoleEntityDrawer implements Drawable {
    private Entity entity;
    private ConsoleFrameDrawer consoleFrameDrawer;

    public ConsoleEntityDrawer(Entity entity, ConsoleFrameDrawer consoleFrameDrawer) {
        this.entity = entity;
        this.consoleFrameDrawer = consoleFrameDrawer;
    }

    protected char getBodyCharacterFor(int i) {
        return '?';
    }

    @Override
    public void draw() {
        ConsoleFrame frame = consoleFrameDrawer.getFrame();
        LinkedList<Location> body = entity.getBody();

        int i = 0;
        Iterator<Location> iterator = body.iterator();
        while (iterator.hasNext()) {
            frame.setCell(new Point(iterator.next()), getBodyCharacterFor(i));
            i++;
        }
    }
}
