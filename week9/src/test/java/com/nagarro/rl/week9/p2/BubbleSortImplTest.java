package com.nagarro.rl.week9.p2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortImplTest {

    @Test
    public void testSortIntegerList() {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(5,4,3,2,1));
        BubbleSortImpl.bubbleSort(integerList);
        assertEquals(Arrays.asList(1,2,3,4,5), integerList);
    }

    @Test
    public void testSortStringList() {
        List<String> stringList = new ArrayList<>(Arrays.asList("e", "d", "c", "b", "a"));
        BubbleSortImpl.bubbleSort(stringList);
        assertEquals(Arrays.asList("a", "b", "c", "d", "e"), stringList);
    }

    @Test
    public void testSortEmptyList() {
        List<Integer> list = new ArrayList<>();
        BubbleSortImpl.bubbleSort(list);
        assertEquals(new ArrayList<>(), list);
    }
}