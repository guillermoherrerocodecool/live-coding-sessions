package com.codecool.codewars.strongestevennumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrongestEvenNumberFinderTest {
    StrongestEvenNumberFinder finder = new StrongestEvenNumberFinder();

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0",
            "2, 1, 2",
            "2, 1, 3",
            "8, 1, 9",
            "8, 1, 9",
            "8, 5, 10",
            "8, 5, 10",
            "16, 4, 20",
            "48, 48, 56",
            "192, 129, 193",
    })
    void findWithinInterval(int expected, int start, int end) {
        int result = finder.findWithinInterval(start, end);

        assertEquals(expected, result);
    }
}