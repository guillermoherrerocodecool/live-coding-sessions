package com.codecool.codewars.parseintreloaded;

import com.codecool.codewars.parseintreloaded.multiplier.MultipliersProvider;
import com.codecool.codewars.parseintreloaded.tens.TensParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NumberParserTest {
    TensParser tensParser = mock(TensParser.class);
    MultipliersProvider multipliersProvider = new MultipliersProvider();
    NumberParser numberParser = new NumberParser(tensParser, multipliersProvider.getMultipliers());

    @ParameterizedTest
    @CsvSource({
            "1, zero",
            "1, twenty-one",
            "1, ninety-nine",
            "100, one hundred",
            "1000, one thousand",
            "100000, one hundred thousand",
            "1000000, one million",
            "100000000, one hundred million",
            "1000000000, one billion",
    })
    void parse(long expected, String literal) {
        when(tensParser.parse(anyString())).thenReturn(1);

        long result = numberParser.parse(literal);

        assertEquals(expected, result);
    }
}