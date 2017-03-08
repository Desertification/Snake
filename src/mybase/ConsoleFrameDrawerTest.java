package mybase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by thoma on 08-Mar-17.
 */
class ConsoleFrameDrawerTest {
    private ConsoleFrameDrawer consoleFrameDrawer;
    private ByteArrayOutputStream byteArrayOutputStream;

    private String getStreamOutput() {
        try {
            return byteArrayOutputStream.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return byteArrayOutputStream.toString();
        }
    }

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        consoleFrameDrawer = new ConsoleFrameDrawer(printStream);
    }

    @Test
    void drawFrame() {
        String ls = System.lineSeparator();
        String expected = "abc" + ls + " d " + ls + "  e" + ls;

        ConsoleFrame frame = new ConsoleFrame(new Dimension(3, 3));
        frame.setCell(new Point(0, 0), "a");
        frame.setCell(new Point(1, 0), "b");
        frame.setCell(new Point(2, 0), "c");
        frame.setCell(new Point(1, 1), "d");
        frame.setCell(new Point(2, 2), "e");
        consoleFrameDrawer.drawFrame(frame);

        assertTrue(expected.equals(getStreamOutput()));

    }
}