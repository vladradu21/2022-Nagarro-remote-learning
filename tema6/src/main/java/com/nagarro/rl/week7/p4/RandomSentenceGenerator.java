package com.nagarro.rl.week7.p4;

import java.util.Random;

public class RandomSentenceGenerator {
    private static final String[] ARTICLES = {"the", "a", "one", "some", "any"};
    private static final String[] NOUNS = {"boy", "girl", "dog", "town", "car"};
    private static final String[] VERBS = {"drove", "jumped", "ran", "walked", "skipped"};
    private static final String[] PREPOSITIONS = {"to", "from", "over", "under", "on"};

    static final int MIN_SENTENCES_IN_STORY = 3;
    static final int MAX_SENTENCES_IN_STORY = 7;

    public static String generateStory() {
        Random random = new Random();
        int numSentences = MIN_SENTENCES_IN_STORY + random.nextInt(MAX_SENTENCES_IN_STORY - MIN_SENTENCES_IN_STORY + 1);

        StringBuilder storyBuilder = new StringBuilder();
        for (int i = 0; i < numSentences; i++) {
            storyBuilder.append(generateSentence(random));
        }

        return storyBuilder.toString().trim();
    }

    private static String generateSentence(Random random) {
        StringBuilder sentenceBuilder = new StringBuilder();

        sentenceBuilder.append(capitalizeFirstLetter(getRandomWord(random, ARTICLES))).append(" ")
                .append(getRandomWord(random, NOUNS)).append(" ")
                .append(getRandomWord(random, VERBS)).append(" ")
                .append(getRandomWord(random, PREPOSITIONS)).append(" ")
                .append(getRandomWord(random, ARTICLES)).append(" ")
                .append(getRandomWord(random, NOUNS)).append(". ");
        return sentenceBuilder.toString();
    }

    private static String getRandomWord(Random random, String[] words) {
        return words[random.nextInt(words.length)];
    }

    private static String capitalizeFirstLetter(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}
