package com.codecool.codewars.wordspin;

import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class WordSpinner {

    private final int minimumWordLengthToStartSpinning;

    public WordSpinner(int minimumWordLengthToStartSpinning) {
        this.minimumWordLengthToStartSpinning = minimumWordLengthToStartSpinning;
    }

    public String spin(String text) {
        return Stream.of(text.split(" "))
                .filter(word -> !word.isEmpty())
                .map(transform())
                .collect(joining(" "));
    }

    private Function<String, String> transform() {
        return word -> {
            if (word.length() < minimumWordLengthToStartSpinning) {
                return word;
            }
            return new StringBuilder(word).reverse().toString();
        };
    }
}
