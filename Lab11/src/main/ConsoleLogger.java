package main;

import storage.SensorData;

import java.util.Observable;
import java.util.Observer;

/**
 * Reacts to updates on the observed data by printing the new values.
 */
public class ConsoleLogger implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (!(arg instanceof SensorData)) {
            return;
        }
        System.out.println("New steps: " + arg);
    }
}
