package com.nagarro.rl.week5.p2;

public interface List<T> {
    void add(T element) throws NullOrEmptyValueException, NonNumericValueException;

    T get(int position) throws ArrayIndexOutOfBoundsException;

    boolean contains(T element) throws NullOrEmptyValueException;

    boolean containsAll(List<T> foreignList) throws ArrayIndexOutOfBoundsException, NullOrEmptyValueException;

    int size();
}
