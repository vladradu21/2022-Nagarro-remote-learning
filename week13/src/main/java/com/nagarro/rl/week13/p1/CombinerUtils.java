package com.nagarro.rl.week13.p1;

import java.util.function.Consumer;

public class CombinerUtils {
    public static <T> void applyCombination(T[] data, Combiner<T> combiner, Consumer<T> consumer) {
        if (data.length >= 4) {
            consumer.accept(combiner.combine(data[0], data[1], data[2], data[3]));
        } else {
            throw new IllegalArgumentException("Data must have at least 4 elements");
        }
    }
}
