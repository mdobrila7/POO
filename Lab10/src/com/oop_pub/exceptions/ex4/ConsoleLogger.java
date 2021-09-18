package com.oop_pub.exceptions.ex4;

import java.util.EnumSet;

public class ConsoleLogger extends LoggerBase {
    ConsoleLogger(EnumSet<LogLevel> set) {
        super(set);
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[Console] " + message);
    }
}
