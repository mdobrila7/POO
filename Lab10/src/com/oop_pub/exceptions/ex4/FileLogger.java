package com.oop_pub.exceptions.ex4;

import java.util.EnumSet;

public class FileLogger extends LoggerBase {
    FileLogger(EnumSet<LogLevel> set) {
        super(set);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[File] " + message);
    }
}
