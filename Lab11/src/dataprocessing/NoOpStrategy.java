package dataprocessing;

/**
 * No implementation. If the input is correct this should never be instantiated.
 */
public class NoOpStrategy implements StepCountStrategy {
    @Override
    public int getTotalSteps() {
        return -1;
    }

    @Override
    public String getStrategyDescription() {
        return "No op strategy";
    }
}
