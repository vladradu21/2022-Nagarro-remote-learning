package com.nagarro.rl.week14.p1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {121, 1221, 12321})
    public void testIsPalindromicWithPalindromeNumber(int number) {
        assertTrue(PalindromicNumbers.isPalindromic(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {123, 1234, 12345})
    public void testIsPalindromicWithNonPalindromeNumber(int number) {
        assertFalse(PalindromicNumbers.isPalindromic(number));
    }

    @Test
    public void testCountPalindromicNumbers() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PalindromicNumbers.countPalindromicNumbers();

        String expectedOutput = "Odd: 50\r\n" +
                                "Even: 40\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}