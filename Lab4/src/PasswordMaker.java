import java.util.Random;

public class PasswordMaker {
    private final int MAGIC_NUMBER = 20;
    private final String MAGIC_STRING = "KAJSHDASKJHFWEUIBDLJ";
    private String name;
    private static int COUNT = 0;

    private static PasswordMaker instance = new PasswordMaker("a");

    private PasswordMaker(String name) {
        this.name = name;
    }

    String getPassword() {
        RandomStringGenerator r = new RandomStringGenerator(MAGIC_NUMBER, MAGIC_STRING.substring(0,10));
        Random rand = new Random();

        return r.next() + String.valueOf(name.length()) + rand.nextInt(101);
    }

    public static PasswordMaker getInstance() {
        COUNT++;
        return instance;
    }

    public static int getCount() {
        return COUNT;
    }
}
