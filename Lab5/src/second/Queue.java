package second;

import first.Task;

import java.util.ArrayList;

public class Queue extends Stack{
    @Override
    public Task pop() {
        Task t = list.get(0);
        list.remove(0);
        return t;
    }
}
