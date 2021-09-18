import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(Integer i = 0 ; i < 10; i++) {
            arr.add(i);
        }

        MyImmutableArray a = new MyImmutableArray(arr);
        a.getArray().clear();

        System.out.println(a.getArray());

    }
}
