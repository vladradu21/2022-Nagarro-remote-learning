package com.nagarro.rl.week9.p1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MyCollectionTest {

    @ParameterizedTest
    @MethodSource("stringCollectionProvider")
    public void testStringCollection(List<String> inputList, List<String> containsList, boolean expectedContainsAll) {
        MyCollection<String> myStringCollection = new MyCollectionImpl<>();
        assertTrue(myStringCollection.addAll(inputList));
        assertEquals(expectedContainsAll, myStringCollection.containsAll(containsList));
    }

    private static Stream<Arguments> stringCollectionProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList("hello", "world"), Arrays.asList("hello"), true),
                Arguments.of(Arrays.asList("hello", "world"), Collections.singletonList("goodbye"), false),
                Arguments.of(Collections.singletonList("hello"), Collections.singletonList("hello"), true)
        );
    }


    @ParameterizedTest
    @MethodSource("integerCollectionProvider")
    public void testIntegerCollection(List<Integer> inputList, List<Integer> containsList, boolean expectedContainsAll) {
        MyCollection<Integer> myIntCollection = new MyCollectionImpl<>();
        assertTrue(myIntCollection.addAll(inputList));
        assertEquals(expectedContainsAll, myIntCollection.containsAll(containsList));
    }

    private static Stream<Arguments> integerCollectionProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(2, 3), true),
                Arguments.of(Arrays.asList(1, 2, 3), Collections.singletonList(4), false),
                Arguments.of(Arrays.asList(1, 2, 3), Collections.singletonList(1), true)
        );
    }

    @Test
    public void testEmptyCollection() {
        MyCollection<String> myStringCollection = new MyCollectionImpl<>();
        assertFalse(myStringCollection.containsAll(Arrays.asList("hello")));
    }

    @Test
    public void testNullCollection() {
        MyCollection<String> myStringCollection = new MyCollectionImpl<>();
        assertFalse(myStringCollection.addAll(null));
        assertFalse(myStringCollection.containsAll(null));
    }
}