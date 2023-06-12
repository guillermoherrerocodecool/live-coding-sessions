package com.codecool.codewars.scramblies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScramblerTest {
    Scrambler scrambler = new Scrambler();

    @ParameterizedTest
    @CsvFileSource(resources = "/scramblies/scrambler.csv", numLinesToSkip = 1)
    void scramble(boolean expected, String string1, String string2) {
        boolean result = scrambler.scramble(string1, string2);

        assertEquals(expected, result);
    }

    @Test
    public void largeTest() {
        String string1 = "abcdefghijklmnopqrstuvwxyz".repeat(10_000);
        String string2 = "zyxcba".repeat(9_000);

        boolean result = scrambler.scramble(string1, string2);

        assertTrue(result);
    }
}