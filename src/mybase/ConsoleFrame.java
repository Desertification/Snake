package mybase;

/**
 * Created by thoma on 08-Mar-17.
 */
public class ConsoleFrame {
    private Dimension dimension;
    private char[][] frame;

    ConsoleFrame(Dimension dimension) {
        this.dimension = dimension;
        frame = new char[dimension.width][dimension.height];
    }

    public void setCell(Point point, char value) throws PointOutOfBoundsException {
        try {
            frame[point.x][point.y] = value;
        } catch (IndexOutOfBoundsException e) {
            throw new PointOutOfBoundsException(point);
        }
    }

    public char getCell(Point point) throws PointOutOfBoundsException {
        try {
            return frame[point.x][point.y];
        } catch (Exception e) {
            throw new PointOutOfBoundsException(point);
        }
    }

    public void clear() {
        frame = new char[dimension.width][dimension.height];
    }

    public Dimension getDimension() {
        return dimension;
    }
}

