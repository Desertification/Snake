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

    public ConsoleFrame getFrame() {
        return frame;
    }

    public void clearFrame() {
        frame.clear();
    }

    public void drawFrame() {
        for (int y = 0; y < dimension.height; y++) {
            for (int x = 0; x < dimension.width; x++) {
                drawCell(frame, new Point(x, y));
            }
            printStream.println();
        }
    }

    private void drawCell(ConsoleFrame frame, Point point) {
        char cell = frame.getCell(point);
        cell = replaceNullWithSpace(cell);
        printStream.print(cell);
    }

    private char replaceNullWithSpace(char cell) {
        final char NULL_CHAR = '\u0000';
        if (cell == NULL_CHAR) {
            cell = ' ';
        }
        return cell;
    }
}
