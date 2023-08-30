package com.nagarro.rl.week7.p5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PigLatinTest {

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"The quick brown fox", "heTay uickqay rownbay oxfay"},
                {"jumps over the lazy dog", "umpsjay veroay hetay azylay ogday"},
                {"The cat", "heTay atcay"},
        });
    }

    private final String input;
    private final String expectedOutput;

    public PigLatinTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void testToPigLatin() {
        PigLatin pigLatin = new PigLatin();
        String result = pigLatin.toPigLatin(input);
        assertEquals(expectedOutput, result);
    }

}

