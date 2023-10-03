package com.codecool.codewars.stringmerge;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class StringMerger {
    public String merge(String word1, String word2, char letter) {
        return IntStream.concat(
                        word1.chars().takeWhile(n -> n != letter),
                        word2.chars().dropWhile(n -> n != letter)
                ).mapToObj(Character::toString)
                .collect(joining());
    }
}
