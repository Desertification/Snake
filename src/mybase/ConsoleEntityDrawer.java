package mybase;

import myLinkedList.Iterator;
import myLinkedList.LinkedList;

/**
 * Created by thoma on 19-Mar-17.
 * base class that contains to logic to draw entities on the console
 */
public class ConsoleEntityDrawer implements Drawable {
    private Entity entity;
    private ConsoleFrameDrawer consoleFrameDrawer;

    /**
     * @param entity             entity to draw
     * @param consoleFrameDrawer the console drawer that contains and prints the frames
     */
    public ConsoleEntityDrawer(Entity entity, ConsoleFrameDrawer consoleFrameDrawer) {
        this.entity = entity;
        this.consoleFrameDrawer = consoleFrameDrawer;
    }

    /**
     * @param i index, for when the entity has multiple parts
     * @return the char representing that part visually
     */
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
