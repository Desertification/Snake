package mybase;

import biz.source_code.utils.RawConsoleInput;

import java.io.IOException;

/**
 * Created by thoma on 05-Mar-17.
 */
public class ConsoleScanner {
    public int next() throws IOException {
        return RawConsoleInput.read(true);
    }
}
