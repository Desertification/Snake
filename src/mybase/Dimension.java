package mybase;

/**
 * Created by thoma on 08-Mar-17.
 */
public class Dimension {
    public final int width;
    public final int height;

    public Dimension() {
        this(0, 0);
    }

    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
