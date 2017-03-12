package mybase;

import java.io.IOException;

/**
 * Created by thoma on 12-Mar-17.
 */
public class KeyViewer {
    public static void main(String[] args) {
        ConsoleScanner consoleScanner = new ConsoleScanner();
        while (true) {
            try {
                System.out.println(consoleScanner.next());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}