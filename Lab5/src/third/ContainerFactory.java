package third;

import second.Container;
import second.Queue;
import second.Stack;

public class ContainerFactory implements IFactory {
    public static final ContainerFactory INSTANCE = new ContainerFactory();

    private ContainerFactory() {
    }

    public Container createContainer(Strategy strategy) {
        Container c = null;
        if (strategy == Strategy.LIFO) {
            c = new Stack();
        } else if (strategy == Strategy.FIFO) {
            c = new Queue();
        }

        return c;
    }
}