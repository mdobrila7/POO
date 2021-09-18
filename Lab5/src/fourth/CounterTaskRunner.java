package fourth;

import first.Task;
import third.Strategy;

public class CounterTaskRunner extends AbstractTaskRunner {
    private int counter;

    public CounterTaskRunner(Strategy strategy) {
        super(strategy);
        counter = 0;
    }

    @Override
    protected void afterExecution(Task task) {
        counter++;
    }

    @Override
    public String getCounter() {
        return String.valueOf(counter);
    }
}
