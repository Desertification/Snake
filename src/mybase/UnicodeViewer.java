package mybase;

import static java.lang.System.out;

public class UnicodeViewer {
    static void printSamples(int start, int stop) {
        // write your code here

        for (int i = start; i < stop; i++) {
            String hex = Integer.toHexString(i);
            out.println("0x" + hex + "|" + i + " = " + (char) i);

            out.print((char) i);
            out.print((char) i);

            out.println();

            out.print((char) i);
            out.println((char) i);
            out.println();
        }
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                int start = Integer.parseInt(args[0]);
                int stop = Integer.parseInt(args[1]);

                printSamples(start, stop);

            } catch (NumberFormatException e) {
                out.println("invalid values");
            }
        } else {
            out.println("Enter a starting and stopping number");
        }
    }
}