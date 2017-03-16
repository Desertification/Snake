package mybase;

import myLinkedList.Iterator;
import myLinkedList.LinkedList;

/**
 * Created by thoma on 15-Mar-17.
 */
public class Hitbox {
    private LinkedList<Location> body;

    public Hitbox(LinkedList<Location> body) {
        this.body = body;
    }

    public Iterator<Location> iterator() {
        return body.iterator();
    }

    protected boolean overlapping(Location location1, Location location2) {
        return location1.equals(location2);
    }

    public boolean isCollidingWith(Hitbox hitbox) {
        Iterator<Location> thisIterator = iterator();
        Iterator<Location> theirIterator = hitbox.iterator();
        while (thisIterator.hasNext()) {
            while (theirIterator.hasNext()) {
                Location thisLocation = thisIterator.next();
                Location theirLocation = theirIterator.next();
                if (overlapping(thisLocation, theirLocation)) {
                    return true;
                }
            }
        }
        return false;
    }
}
