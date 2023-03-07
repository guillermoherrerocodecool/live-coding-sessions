package com.codecool.codewars.parseintreloaded.tens;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TensParserTest {
    ConvertersProvider convertersProvider = new ConvertersProvider();
    TensParser tensParser = new TensParser(convertersProvider.getConverters());

    @ParameterizedTest
    @CsvFileSource(resources = "/parseintreloaded/tensparser.csv", numLinesToSkip = 1)
    void parse(int expected, String literal) {
        int result = tensParser.parse(literal);

        assertEquals(expected, result);
    }
}