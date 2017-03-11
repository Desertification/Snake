package mybase;

/**
 * Created by thoma on 04-Mar-17.
 */
public class Point {
    public int x, y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this(point.x, point.y);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(Point point) {
        this.set(point.x, point.y);
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}
