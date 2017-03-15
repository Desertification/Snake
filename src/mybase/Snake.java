package mybase;

import myLinkedList.LinkedList;

class Snake implements Drawable, Updatable {
    private Updatable updateBehavior;
    private Drawable drawBehavior;
    private LinkedList<Location> body;
    private Direction direction;

    Snake() {
        body = new LinkedList<>(new Location(0, 0));
        direction = Direction.RIGHT;
    }

    public LinkedList<Location> getBody() {
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
        body.append(new Location(body.last()));
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        if (this.direction != direction.opposite()) {
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