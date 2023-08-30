package com.nagarro.rl.week9.p2;

import java.util.Arrays;
import java.util.Collection;

public class BubbleSortImpl {

    public static <T extends Comparable<? super T>> void bubbleSort(Collection<T> collection) {
        T[] arrayOfT = collection.toArray((T[]) new Comparable[collection.size()]);
        int length = arrayOfT.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arrayOfT[j].compareTo(arrayOfT[j + 1]) > 0) {
                    T aux = arrayOfT[j];
                    arrayOfT[j] = arrayOfT[j + 1];
                    arrayOfT[j + 1] = aux;
                }
            }
        }

        collection.clear();
        collection.addAll(Arrays.asList(arrayOfT));
    }
}
