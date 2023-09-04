package com.codecool.codewars.ascenddescendrepeat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpDownSequenceTest {
    UpDownSequence sequenceEqual = new UpDownSequence(0, 0);
    UpDownSequence sequencePositive = new UpDownSequence(0, 2);
    UpDownSequence sequenceNegative = new UpDownSequence(-1, 1);

    @ParameterizedTest
    @ValueSource(ints = {0, 0, 0, 0, 0, 0})
    void nextEqual(int expected) {
        int result = sequenceEqual.next();

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 1, 0, 1, 2, 1, 0})
    void nextPositive(int expected) {
        int result = sequencePositive.next();

        assertEquals(expected, result);
    }
}