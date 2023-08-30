package com.nagarro.rl.week7.p3;

import java.util.Arrays;
import java.util.List;

public class TitlelizerImpl implements Titlelizer {

    private static final List<String> PREPOSITIONS = Arrays.asList("the", "a", "to", "in", "of", "is");


    @Override
    public String titlelize(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        if (inputString.isEmpty()) {
            return " ";
        }
        String[] words = splitIntoWords(inputString);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == 0 || !isPreposition(word)) {
                sb.append(titlelizeWord(word));
            } else {
                sb.append(word.toLowerCase());
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private String[] splitIntoWords(String inputString) {
        return inputString.split("\\s+");
    }

    private boolean isPreposition(String word) {
        return PREPOSITIONS.contains(word.toLowerCase());
    }

    private String titlelizeWord(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
    }

}