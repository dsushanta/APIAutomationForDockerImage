package com.bravo.johny.jsonserver.config;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class LogConfig {
    public static PrintStream log;

    static {
        try {
            log = new PrintStream(new FileOutputStream("logging.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
