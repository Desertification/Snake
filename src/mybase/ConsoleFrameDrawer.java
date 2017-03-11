package mybase;

import java.io.PrintStream;

/**
 * Created by thoma on 08-Mar-17.
 */
public class ConsoleFrameDrawer {

    private PrintStream printStream;

    ConsoleFrameDrawer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void drawFrame(ConsoleFrame frame) {
        Dimension dimension = frame.getDimension();
        for (int y = 0; y < dimension.y; y++) {
            for (int x = 0; x < dimension.x; x++) {
                try {
                    String cell = frame.getCell(new Point(x, y));
                    if (cell == null) {
                        cell = " ";
                    }
                    printStream.print(cell);
                } catch (PointOutOfBoundsException ignored) {
                }
            }
            printStream.println();
        }
    }
}
