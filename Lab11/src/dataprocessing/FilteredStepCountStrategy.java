package dataprocessing;

import storage.DataRepository;
import storage.SensorData;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Strategy that sums up all the steps that meet the following conditions:
 *   * the step count is a positive number
 *   * no outliers: huge spike in steps over a very short period.
 *
 *   The condition for no outliers: no more than [MAX_DIFF_STEPS_CONSECUTIVE_RECORDS]
 *   in less than [TIME_FOR_MAX_DIFF] milliseconds.
 */
public class FilteredStepCountStrategy implements StepCountStrategy {

    private static final int MAX_DIFF_STEPS_CONSECUTIVE_RECORDS = 1000;
    private static final long TIME_FOR_MAX_DIFF = TimeUnit.SECONDS.toMillis(1);
    private final DataRepository repository;

    FilteredStepCountStrategy(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public int getTotalSteps() {
        List<SensorData> data = repository.getData();
        if (data.isEmpty()) {
            return 0;
        }

        int totalSteps = 0;
        SensorData prev = data.get(0);
        for (SensorData record : data) {
            if (record.getStepsCount() < 0
                    || (record.getTimestamp() - prev.getTimestamp() < TIME_FOR_MAX_DIFF
                    && Math.abs(record.getStepsCount() - prev.getStepsCount()) > MAX_DIFF_STEPS_CONSECUTIVE_RECORDS)) {
                //  ignore this
                continue;
            }
            totalSteps += record.getStepsCount();
            prev = record;
        }
        return totalSteps;
    }

    @Override
    public String getStrategyDescription() {
        return "Filtered total steps";
    }
}
