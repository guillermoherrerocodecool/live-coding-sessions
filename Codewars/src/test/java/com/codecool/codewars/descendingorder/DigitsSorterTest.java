package com.codecool.codewars.descendingorder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitsSorterTest {
    DigitsSorter digitsSorter = new DigitsSorter();

    @ParameterizedTest
    @CsvFileSource(
            resources = "/descendingorder/find-test.csv", 
            numLinesToSkip = 1)
    void find(int expected, int number) {
        int result = digitsSorter.sortDesc(number);

        assertEquals(expected, result);
    }
}