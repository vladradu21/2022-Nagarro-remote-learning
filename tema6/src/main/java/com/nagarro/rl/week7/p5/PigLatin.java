package com.nagarro.rl.week7.p5;

import java.util.StringTokenizer;

public class PigLatin {

    public String toPigLatin(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input);
        StringBuilder sb = new StringBuilder();

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            String pigLatinWord = convertToPigLatin(word);
            sb.append(pigLatinWord).append(" ");
        }

        return sb.toString().trim();
    }

    private String convertToPigLatin(String word) {
        if (word.length() == 1) {
            return word + "ay";
        }
        return word.substring(1) + word.charAt(0) + "ay";
    }

}


