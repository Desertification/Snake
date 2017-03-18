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

    public Hitbox() {
    }

    public void setBody(LinkedList<Location> body) {
        this.body = body;
    }

    public Iterator<Location> iterator() {
        return body.iterator();
    }

    protected boolean overlapping(Location location1, Location location2) {
        return location1.equals(location2);
    }

    protected boolean ownHitbox(Hitbox hitbox) {
        return this == hitbox;
    }

    public boolean isCollidingWith(Hitbox hitbox) {
        return !ownHitbox(hitbox) && collidingWithAnyPart(hitbox);
    }

    private boolean collidingWithAnyPart(Hitbox hitbox) {
        Iterator<Location> thisIterator = iterator();
        Iterator<Location> theirIterator = hitbox.iterator();
        while (thisIterator.hasNext()) {
            Location thisLocation = thisIterator.next();
            while (theirIterator.hasNext()) {
                Location theirLocation = theirIterator.next();
                if (overlapping(thisLocation, theirLocation)) {
                    return true;
                }
            }
        }
        return false;
    }
}
