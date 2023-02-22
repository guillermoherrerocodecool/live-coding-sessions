package com.codecool.codewars.wordspin;

import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;

public class WordSpinner2 {
    private final int minimumWordLength;

    public WordSpinner2(int minimumWordLength) {
        this.minimumWordLength = minimumWordLength;
    }

    public String spin(String words) {
        return Stream.of(words.split(" "))
                .map(this::transform)
                .collect(joining(" "));
    }

    private String transform(String word) {
        return word.length() < minimumWordLength ? word : reverse(word);
    }

    private String reverse(String word) {
        Stack<String> reversed = Stream.of(word.split(""))
                .collect(toCollection(Stack::new));
        return Stream.generate(reversed::pop)
                .limit(reversed.size())
                .collect(joining());
    }
}
