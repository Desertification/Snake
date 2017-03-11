package mybase;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ConsoleBenchmark {
    private static String[] chars = {"\u2588", "\u00DE", "\u25a0", "\u2591", "\u2592", "\u2593"};
    private static Random random = new Random();

    public static void main(String[] args) {
        Timer timer = new Timer(false);
        timer.scheduleAtFixedRate(new FrameTask(), 0, 40);
    }

    static class FrameTask extends TimerTask {
        ConsoleFrameDrawer consoleFrameDrawer = new ConsoleFrameDrawer(System.out);

        @Override
        public void run() {
            long fg_start = System.currentTimeMillis();
            int size_x = 30;
            int size_y = 15;
            ConsoleFrame frame = new ConsoleFrame(new Dimension(size_x, size_y));
            for (int y = 0; y < size_y; y++) {
                for (int x = 0; x < size_x; x++) {
                    frame.setCell(new Point(x, y), chars[random.nextInt(chars.length)]);
                }
            }
            long fg_stop = System.currentTimeMillis();

            long d_start = System.currentTimeMillis();
            consoleFrameDrawer.drawFrame(frame); //takes far longer to draw than to create a frame
            long d_stop = System.currentTimeMillis();

            System.out.println((fg_stop - fg_start) + " " + (d_stop - d_start));
        }
    }
}