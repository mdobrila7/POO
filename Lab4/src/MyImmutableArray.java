import java.util.ArrayList;

public class MyImmutableArray {
    public final ArrayList<Integer> immutableArray;

    MyImmutableArray(ArrayList<Integer> immutableArray) {
        this.immutableArray = immutableArray;
    }

    ArrayList<Integer> getArray() {
        ArrayList<Integer> arr = new ArrayList<Integer>(immutableArray);
        return arr;
    }
}
