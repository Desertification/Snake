package mybase;

import myLinkedList.Iterator;

/**
 * Created by thoma on 16-Mar-17.
 */
public class HeadFirstHitbox extends Hitbox {
    public HeadFirstHitbox() {
    }

    @Override
    public boolean isCollidingWith(Hitbox hitbox) {
        return headCollidingWithAnyPart(hitbox);
    }

    private boolean headCollidingWithAnyPart(Hitbox hitbox) {
        Location head = iterator().next();
        Iterator<Location> theirIterator = hitbox.iterator();
        if (ownHitbox(hitbox)) {
            skipTheirHead(theirIterator);
        }
        while (theirIterator.hasNext()) {
            Location theirLocation = theirIterator.next();
            if (overlapping(head, theirLocation)) {
                return true;
            }
        }
        return false;
    }

    private void skipTheirHead(Iterator<Location> theirIterator) {
        theirIterator.next();
    }
}
