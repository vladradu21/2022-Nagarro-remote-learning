package com.nagarro.rl.week13.p1;

@FunctionalInterface
public interface Combiner<T> {
    T combine(T a, T b, T c, T d);
}
