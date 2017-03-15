package mybase;

/**
 * Created by thoma on 04-Mar-17.
 */
enum Direction {
    UP, DOWN, LEFT, RIGHT;

    static {
        UP.opposite = DOWN;
        DOWN.opposite = UP;
        LEFT.opposite = RIGHT;
        RIGHT.opposite = LEFT;
    }

    // http://stackoverflow.com/a/18883717
    private Direction opposite;

    public Direction opposite() {
        return opposite;
    }
}