package com.nagarro.rl.week7.p4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomSentenceGeneratorTest {

    @Test
    void testGenerateStory() {
        String story = RandomSentenceGenerator.generateStory();
        assertNotNull(story);
        assertTrue(story.length() > 0);
        assertTrue(story.endsWith("."));

        String[] sentences = story.split("\\. ");
        assertTrue(sentences.length >= RandomSentenceGenerator.MIN_SENTENCES_IN_STORY);
        assertTrue(sentences.length <= RandomSentenceGenerator.MAX_SENTENCES_IN_STORY);

        for (String sentence : sentences) {
            assertTrue(sentence.trim().length() > 0);
            assertTrue(Character.isUpperCase(sentence.charAt(0)));
        }
    }
}