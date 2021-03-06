package mybase;

/**
 * Created by thoma on 11-Mar-17.
 */
public final class Navigation {
    private Navigation() {
    }

    public static Point getNextPoint(Point point, Direction direction) {
        switch (direction) {
            case DOWN:
                return new Point(point.x, point.y + 1);
            case UP:
                return new Point(point.x, point.y - 1);
            case LEFT:
                return new Point(point.x - 1, point.y);
            case RIGHT:
                return new Point(point.x + 1, point.y);
            default:
                return point;
        }
    }

    public static boolean isOutOfBounds(Point point, Dimension bounds) {
        if (point.x < 0 || point.x >= bounds.width) {
            return true;
        }
        return point.y < 0 || point.y >= bounds.height;

    }

    // todo fix code duplication
    public static Point warp(Point point, Dimension bounds) {
        if (point.x < 0) {
            point = new Point(bounds.width - 1, point.y);
        } else if (point.x >= bounds.width) {
            point = new Point(0, point.y);
        }
        if (point.y < 0) {
            point = new Point(point.x, bounds.height - 1);
        } else if (point.y >= bounds.height) {
            point = new Point(point.x, 0);
        }
        return point;
    }
}
