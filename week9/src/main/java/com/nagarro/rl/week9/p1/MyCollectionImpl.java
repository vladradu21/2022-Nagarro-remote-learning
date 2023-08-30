package com.nagarro.rl.week9.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyCollectionImpl<E> implements MyCollection<E> {
    private List<E> elements = new ArrayList<>();

    @Override
    public boolean containsAll(Collection<E> c) {
        if(c == null) {
            return false;
        }
        return elements.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<E> c) {
        if(c == null) {
            return false;
        }
        return elements.addAll(c);
    }
}
