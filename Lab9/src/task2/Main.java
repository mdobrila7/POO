package task2;

import java.util.*;

public class Main {
    public static <T extends Sumabil> T add(Collection<T> array) {
        T sum = null;
        Iterator<T> iterator = array.iterator();

        sum = iterator.next();

        while(iterator.hasNext()) {
            sum.addValue(iterator.next());
        }
        return sum;
    }


    public static void main(String[] args) {
        List<MyVector3> myList = new ArrayList<>();
        myList.add(new MyVector3(2,3,4));
        myList.add(new MyVector3(3,7,1));
        System.out.println(add(myList));

    }
}
