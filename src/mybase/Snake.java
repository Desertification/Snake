package mybase;

import myLinkedList.LinkedList;

class Snake implements Drawable, Updatable {
    private UpdateBehavior updateBehavior;
    private DrawBehavior drawBehavior;
    private LinkedList<Point> bodyParts;
    private Direction direction;

    Snake(UpdateBehavior updateBehavior, DrawBehavior drawBehavior) {
        this.updateBehavior = updateBehavior;
        this.drawBehavior = drawBehavior;
        bodyParts = new LinkedList<>(new Point());
    }

    @Override
    public void draw() {
        drawBehavior.draw();
    }

    @Override
    public void update() {
        updateBehavior.update();
    }

    public void grow() {
        bodyParts.append(bodyParts.last());
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) throws IllegalDirectionChangeException {
        if (this.direction == direction) {
            throw new IllegalDirectionChangeException("The snake cannot do a 180 degree direction change");
        } else {
            this.direction = direction;
        }
    }
}

/**
 * Signals that the requested direction change is currently not possible.
 */
class IllegalDirectionChangeException extends Exception {
    public IllegalDirectionChangeException() {
        super();
    }

    public IllegalDirectionChangeException(String message) {
        super(message);
    }

    public IllegalDirectionChangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalDirectionChangeException(Throwable cause) {
        super(cause);
    }
}