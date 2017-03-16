package mybase;

/**
 * Created by thoma on 15-Mar-17.
 */
//todo better name to reflect mutable point
public class Location {
    public int x, y;

    public Location() {
        this(0, 0);
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public Location(Location location) {
        this.x = location.x;
        this.y = location.y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(Point point) {
        this.set(point.x, point.y);
    }

    public boolean equals(Location location) {
        return this.x == location.x && this.y == location.y;
    }

    public String toString() {
        return "Location{" + "x=" + x + ", y=" + y + '}';
    }
}
