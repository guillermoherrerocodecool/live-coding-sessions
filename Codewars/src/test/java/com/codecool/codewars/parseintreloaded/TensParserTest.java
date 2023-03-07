package com.codecool.codewars.parseintreloaded;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TensParserTest {
    TensParser parser = new TensParser();

    @ParameterizedTest
    @CsvFileSource(
            resources = "/parseintreloaded/tensparser.csv",
            numLinesToSkip = 1)
    void parse(int expected, String literal) {
        int result = parser.parse(literal);

        assertEquals(expected, result);
    }
}