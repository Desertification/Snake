package mybase;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A debugging class to measure the performance of the rendering logic in the console
 */
public class ConsoleBenchmark {
    private static char[] chars = {'\u2588', '\u00DE', '\u25a0', '\u2591', '\u2592', '\u2593'};
    private static Random random = new Random();

    /**
     * run the benchmark
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Timer timer = new Timer(false);
        timer.scheduleAtFixedRate(new FrameTask(), 0, 40);
    }

    static class FrameTask extends TimerTask {
        int size_x = 30;
        int size_y = 15;
        ConsoleFrameDrawer consoleFrameDrawer = new ConsoleFrameDrawer(System.out, new Dimension(size_x, size_y));

        @Override
        public void run() {
            long fg_start = System.currentTimeMillis();
            ConsoleFrame frame = consoleFrameDrawer.getFrame();
            Dimension frameDimension = frame.getDimension();
            for (int y = 0; y < frameDimension.height; y++) {
                for (int x = 0; x < frameDimension.width; x++) {
                    frame.setCell(new Point(x, y), chars[random.nextInt(chars.length)]);
                }
            }
            long fg_stop = System.currentTimeMillis();

            long d_start = System.currentTimeMillis();
            consoleFrameDrawer.drawFrame(); //takes far longer to draw than to create a frame
            long d_stop = System.currentTimeMillis();

            System.out.println((fg_stop - fg_start) + " " + (d_stop - d_start));
        }
    }
}