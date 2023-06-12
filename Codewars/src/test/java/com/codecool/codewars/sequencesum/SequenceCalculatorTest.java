package com.codecool.codewars.sequencesum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequenceCalculatorTest {
    SequenceCalculator sequenceCalculator = new SequenceCalculator();

    @ParameterizedTest
    @CsvSource({
            "0, 0, 1, 0",
            "0, 1, 0, 1",
            "0, 2, 1, 1",
            "1, 1, 1, 1",
            "3, 1, 2, 1",
            "6, 1, 3, 1",
            "4, 1, 3, 2",
            "1, 1, 3, 3",
            "2, 2, 2, 2",
            "12, 2, 6, 2",
            "15, 1, 5, 1",
            "5, 1, 5, 3",
    })
    void sumSequence(int expected, int start, int end, int step) {
        int result = sequenceCalculator.sumSequence(start, end, step);

        assertEquals(expected, result);
    }
}