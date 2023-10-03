package com.codecool.codewars.stringmerge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringMergerTest {
    StringMerger stringMerger = new StringMerger();

    @ParameterizedTest
    @CsvSource({
            "'', '', '', a",
            "a, a, a, a",
            "abc, ab, bc, b",
            "abc, aba, cbc, b"
    })
    void merge(String expected, String word1, String word2, char letter) {
        String result = stringMerger.merge(word1, word2, letter);

        assertEquals(expected, result);
    }
}