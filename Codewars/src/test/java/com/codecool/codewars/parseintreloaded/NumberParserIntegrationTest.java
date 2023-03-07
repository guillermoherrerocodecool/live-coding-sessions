package com.codecool.codewars.parseintreloaded;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberParserIntegrationTest {
    TensParser tensParser = new TensParser();
    List<Multiplier> multipliers = List.of(
            new Multiplier("billion", 1000000000),
            new Multiplier("million", 1000000),
            new Multiplier("thousand", 1000),
            new Multiplier("hundred", 100)
    );
    NumberParser numberParser = new NumberParser(tensParser, multipliers);

    @ParameterizedTest
    @CsvFileSource(
            resources = "/parseintreloaded/numberparser.csv",
            numLinesToSkip = 1
    )
    void parse(int expected, String literal) {
        int result = numberParser.parse(literal);

        assertEquals(expected, result);
    }
}