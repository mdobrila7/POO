package dataprocessing;

import storage.DataRepository;

import static main.Utils.BASIC_STRATEGY;
import static main.Utils.FILTERED_STRATEGY;

/**
 * Factory for step count strategies.
 */
public class StepCountStrategyFactory {

    /**
     * Returns an implementation of StepCountStrategy depending on the strategyType parameter
     * @param strategyType a String with the values {@link main.Utils.BASIC_STRATEGY} or {@link main.Utils.FILTERED_STRATEGY}
     * @param dataRepository used by the strategies to obtain the data to process
     * @return
     */
    public StepCountStrategy createStrategy(String strategyType, DataRepository dataRepository) {
        if (strategyType != null) {
            if (strategyType.equals(BASIC_STRATEGY)) {
                return new BasicStepCountStrategy(dataRepository);
            } else if (strategyType.equals(FILTERED_STRATEGY)) {
                return new FilteredStepCountStrategy(dataRepository);
            }
        }
        return new NoOpStrategy();
    }
}
