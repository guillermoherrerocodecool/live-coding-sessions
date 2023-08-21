package com.codecool.codewars.consonantvalue;

import java.util.stream.Stream;

public class ConsonantValueFinder {
    private static final String VOWELS = "[aeiou]";
    private static final int ASCII_SHIFT = 96;

    public int find(String text) {
        return Stream.of(text.split(VOWELS))
                .mapToInt(this::toValue)
                .max()
                .orElse(0);
    }

    private int toValue(String consonants) {
        return consonants.chars()
                .map(ascii -> ascii - ASCII_SHIFT)
                .sum();
    }
}
