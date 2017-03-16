package mybase;

import myLinkedList.Iterator;
import myLinkedList.LinkedList;

/**
 * Created by thoma on 16-Mar-17.
 */
public class SnakeHitbox extends Hitbox {
    public SnakeHitbox(LinkedList<Location> body) {
        super(body);
    }

    @Override
    public boolean isCollidingWith(Hitbox hitbox) {
        Location head = iterator().next(); // todo can be null
        Iterator<Location> theirIterator = hitbox.iterator();
        while (theirIterator.hasNext()) {
            Location theirLocation = theirIterator.next();
            if (overlapping(head, theirLocation)) {
                return true;
            }
        }
        return false;
    }
}
