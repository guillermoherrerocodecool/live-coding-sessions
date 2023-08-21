package com.codecool.codewars.consonantvalue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsonantValueFinderTest {
    ConsonantValueFinder finder = new ConsonantValueFinder();

    @ParameterizedTest
    @CsvSource({
            "0, a",
            "0, e",
            "0, i",
            "0, o",
            "0, u",
            "2, b",
            "26, z",
            "2, ab",
            "5, abc",
            "5, babc",
            "26, zodiac",
            "80, chruschtschov",
            "38, khrushchev",
            "57, strength",
            "73, catchphrase",
            "103, twelfthstreet",
            "80, mischtschenkoana",
    })
    void find(int expected, String text) {
        int result = finder.find(text);

        assertEquals(expected, result);
    }
}