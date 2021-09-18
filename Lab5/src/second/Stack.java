package second;

import first.Task;

import java.util.ArrayList;

public class Stack implements Container {
    protected ArrayList<Task> list = new ArrayList<>();

    @Override
    public Task pop() {
        Task t = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return t;
    }

    @Override
    public void push(Task task) {
        list.add(task);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public void transferFrom(Container container) {
        if(!this.isEmpty()) {
            list.clear();
        }

        while(!container.isEmpty()) {
            push(container.pop());
        }
    }
}
