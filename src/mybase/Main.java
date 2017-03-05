package mybase;

import biz.source_code.utils.RawConsoleInput;

import java.io.IOException;

import static java.lang.System.out;


public class Main {

    public static void main(String[] args) {
        // write your code here
        while (true) {
            try {
                out.println(RawConsoleInput.read(true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
