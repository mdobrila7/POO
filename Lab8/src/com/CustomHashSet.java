package com;

import java.util.Collection;
import java.util.LinkedHashSet;

public class CustomHashSet extends LinkedHashSet<Integer> {

    @Override
    public boolean add(Integer integer) {
        if(integer%2 == 0) {
            return super.add(integer);
        } else {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        for (Integer i : c) {
            if(i%2 == 0) {
                super.add(i);
            }
        };
        return true;
    }
}
