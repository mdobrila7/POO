package dataprocessing;


import storage.DataRepository;
import storage.SensorData;

import java.util.List;

/**
 * Simple strategy that just adds all the steps without other processing.
 */
public class BasicStepCountStrategy implements StepCountStrategy {

    private final DataRepository repository;

    BasicStepCountStrategy(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public int getTotalSteps() {
        List<SensorData> data = repository.getData();
        return data.stream().mapToInt(SensorData::getStepsCount).sum();
    }

    @Override
    public String getStrategyDescription() {
        return "Total steps";
    }
}
