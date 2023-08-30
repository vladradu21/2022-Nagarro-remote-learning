package com.nagarro.rl.week9.p1;

import java.util.Collection;

interface MyCollection<E> {
    boolean containsAll(Collection<E> c);
    boolean addAll(Collection<E> c);
}
