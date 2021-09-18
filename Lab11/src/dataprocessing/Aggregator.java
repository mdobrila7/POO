package dataprocessing;

import java.util.Observable;
import java.util.Observer;

/**
 * Reacts to updates on the observed data by applying an step count strategy.
 */
public class Aggregator implements Observer {
    private final StepCountStrategy strategy;

    public Aggregator(StepCountStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(String.format("%s: %d",
                strategy.getStrategyDescription(), strategy.getTotalSteps()));
    }
}
