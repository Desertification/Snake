package mybase;

import biz.source_code.utils.RawConsoleInput;

import java.io.IOException;

import static java.lang.System.out;

interface Drawable {
    void draw();
}

interface Updatable {
    void update();
}

class snake implements Drawable, Updatable {

    @Override
    public void draw() {

    }

    @Override
    public void update() {

    }
}

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
