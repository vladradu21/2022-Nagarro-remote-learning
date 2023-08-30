package com.nagarro.rl.week14.p1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PalindromicNumbers {

    public static boolean isPalindromic(int number) {
        String numberString = String.valueOf(number);
        return numberString.equals(new StringBuilder(numberString).reverse().toString());
    }

    public static void countPalindromicNumbers(){
        IntStream.rangeClosed(1000, 10000)
                .filter(PalindromicNumbers::isPalindromic)
                .boxed()
                .collect(Collectors.groupingBy(i -> i % 2 == 0, Collectors.counting()))
                .forEach((isEven, count) -> {
                    if (isEven) {
                        System.out.println("Even: " + count);
                    } else {
                        System.out.println("Odd: " + count);
                    }
                });
    }
}
