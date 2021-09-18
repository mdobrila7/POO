package first;

public class RandomOutTask implements Task{
    private int randomNumber;

    public RandomOutTask() {
        randomNumber = (int) Math.random();
    }

    @Override
    public void execute() {
        System.out.println(randomNumber);
    }
}
