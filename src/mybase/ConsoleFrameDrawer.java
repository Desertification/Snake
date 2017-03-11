package mybase;

import java.io.PrintStream;

/**
 * Created by thoma on 08-Mar-17.
 */
public class ConsoleFrameDrawer {

    private PrintStream printStream;
    private ConsoleFrame frame;
    private Dimension dimension;

    ConsoleFrameDrawer(PrintStream printStream, Dimension dimension) {
        this.printStream = printStream;
        this.dimension = dimension;
        frame = new ConsoleFrame(dimension);
    }

    public void drawFrame() {
        drawFrame(frame);
        frame = new ConsoleFrame(dimension);
    }

    private void drawFrame(ConsoleFrame frame) {
        Dimension dimension = frame.getDimension();
        for (int y = 0; y < dimension.y; y++) {
            for (int x = 0; x < dimension.x; x++) {
                try {
                    char cell = frame.getCell(new Point(x, y));
                    if (cell == '\u0000') {
                        cell = ' ';
                    }
                    printStream.print(cell);
                } catch (PointOutOfBoundsException ignored) {
                }
            }
            printStream.println();
        }
    }

    public ConsoleFrame getFrame() {
        return frame;
    }
}
