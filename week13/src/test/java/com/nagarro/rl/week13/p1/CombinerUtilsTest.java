package com.nagarro.rl.week13.p1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CombinerUtilsTest {
    private Integer[] intData;
    private String[] strData;
    private static final Combiner<Integer> summer = (a, b, c, d) -> a + b + c + d;
    private static final Combiner<Integer> productor = (a, b, c, d) -> a * b * c * d;
    private static final Combiner<String> concatenator = (a, b, c, d) -> a + b + c + d;
    private static final Combiner<String> concatenatorWithSpaces = (a, b, c, d) -> a + " " + b + " " + c + " " + d;

    @BeforeEach
    public void setUp() {
        intData = new Integer[]{1, 2, 3, 4};
        strData = new String[]{"one", "two", "three", "four"};
    }

    @Test
    public void testIntegerSummer() {
        CombinerUtils.applyCombination(intData, summer, result -> assertEquals(Integer.valueOf(10), result));
    }

    @Test
    public void testIntegerProductor() {
        CombinerUtils.applyCombination(intData, productor, result -> assertEquals(Integer.valueOf(24), result));
    }

    @Test
    public void testStringConcatenator() {
        CombinerUtils.applyCombination(strData, concatenator, result -> assertEquals("onetwothreefour", result));
    }

    @Test
    public void testStringConcatenatorWithSpaces() {
        CombinerUtils.applyCombination(strData, concatenatorWithSpaces, result -> assertEquals("one two three four", result));
    }

    @Test
    public void testArrayWithLessThanFourElements() {
        assertThrows(IllegalArgumentException.class, () -> CombinerUtils.applyCombination(new Integer[]{1, 2, 3}, summer, result -> {}));
    }

    @Test
    public void testEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> CombinerUtils.applyCombination(new Integer[]{}, summer, result -> {}));
    }
}
