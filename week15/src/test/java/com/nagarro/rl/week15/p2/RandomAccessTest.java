package com.nagarro.rl.week15.p2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomAccessTest {
    private RandomAccess randomAccess;

    @BeforeEach
    public void setUp() {
        randomAccess = new RandomAccess("data.txt");
        int[] nums = {10, 20, 30, 40};
        randomAccess.writeIntegers(nums);
    }

    @Test
    public void testReadThird() throws NumberNotFoundException {
        assertEquals(30, randomAccess.readThird());
    }

    @Test
    public void testReadFourth() throws NumberNotFoundException {
        assertEquals(40, randomAccess.readFourth());
    }
}
