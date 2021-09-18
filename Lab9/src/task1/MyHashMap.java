package task1;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K,V> {
    class Entry {
        K key;
        V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    List<Entry> myList = new ArrayList<>();

    public void put(K key, V value) {
        Entry elem = new Entry(key, value);
        for(Entry i : myList) {
            if(i.key.equals(key)) {
                i.value = value;
                return;
            }
        }
        myList.add(elem);
    }

    public V get(K key) {
        for(Entry i : myList) {
            if(i.key == key) return i.value;
        }
        return null;
    }




}
