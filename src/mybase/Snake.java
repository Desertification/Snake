package mybase;

import myLinkedList.LinkedList;

class Snake implements Drawable, Updatable {
    private Updatable updateBehavior;
    private Drawable drawBehavior;
    private LinkedList<Point> body;
    private Direction direction;

    Snake() {
        body = new LinkedList<>(new Point(0, 0));
        direction = Direction.Right;
    }

    public LinkedList<Point> getBody() {
        return body;
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
        body.append(new Point(body.last()));
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

    public void setUpdateBehavior(Updatable updateBehavior) {
        this.updateBehavior = updateBehavior;
    }

    public void setDrawBehavior(Drawable drawBehavior) {
        this.drawBehavior = drawBehavior;
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