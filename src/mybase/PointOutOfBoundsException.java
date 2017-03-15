package mybase;

public class PointOutOfBoundsException extends RuntimeException {
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
