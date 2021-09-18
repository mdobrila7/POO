package fourth;

import first.Task;
import second.Container;
import third.ContainerFactory;
import third.Strategy;

public class RedoBackTaskRunner extends AbstractTaskRunner {
    private Container container;

    public RedoBackTaskRunner(Strategy strategy) {
        super(strategy);
        container = ContainerFactory.INSTANCE.createContainer(Strategy.LIFO);
    }

    @Override
    protected void afterExecution(Task task) {
        container.push(task);
    }

    @Override
    public void redo() {
        while (!container.isEmpty()) {
            Task task = container.pop();
            task.execute();
        }
    }
}
