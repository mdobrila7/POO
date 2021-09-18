package first;

public class CounterOutTask implements Task{
    public static int counter = 0;

    public CounterOutTask() {
        execute();
    }

    @Override
    public void execute() {
        counter++;
        System.out.println(String.format("Task was executed %d times", counter));
    }
}
