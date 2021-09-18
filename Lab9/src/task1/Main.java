package task1;

public class Main {
    public static void main(String[] args) {
        MyHashMap<TestMyHashMap, Integer> testMap= new MyHashMap<>();
        TestMyHashMap t = new TestMyHashMap("alabala");
        testMap.put(t, 9);
        testMap.put(t, 10);
        System.out.println(testMap.get(t));

    }
}
