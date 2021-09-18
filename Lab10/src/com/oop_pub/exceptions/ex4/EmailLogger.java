package com.oop_pub.exceptions.ex4;

import java.util.EnumSet;

public class EmailLogger extends LoggerBase {
    EmailLogger(EnumSet<LogLevel> set) {
        super(set);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[Email] " + message);
    }
}
