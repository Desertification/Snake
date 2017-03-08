package mybase;

/**
 * Created by thoma on 08-Mar-17.
 */
public class ConsoleFrame {
    private Dimension dimension;
    private String[][] frame;

    ConsoleFrame(Dimension dimension) {
        this.dimension = dimension;
        frame = new String[dimension.x][dimension.y];
    }

    public void setCell(Point point, String value) throws PointOutOfBoundsException {
        try {
            frame[point.x][point.y] = value;
        } catch (IndexOutOfBoundsException e) {
            throw new PointOutOfBoundsException(point);
        }
    }

    public String getCell(Point point) throws PointOutOfBoundsException {
        try {
            return frame[point.x][point.y];
        } catch (Exception e) {
            throw new PointOutOfBoundsException(point);
        }
    }

    public Dimension getDimension() {
        return dimension;
    }
}

class PointOutOfBoundsException extends RuntimeException {
    public PointOutOfBoundsException() {
    }

    public PointOutOfBoundsException(String message) {
        super(message);
    }

    public PointOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PointOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    public PointOutOfBoundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PointOutOfBoundsException(Point point) {
        super("Invalid point: " + point);
    }
}
