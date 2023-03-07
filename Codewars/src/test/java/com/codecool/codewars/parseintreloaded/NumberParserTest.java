package com.codecool.codewars.parseintreloaded;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NumberParserTest {
    TensParser tensParser = mock(TensParser.class);
    //TODO: replace List<Multiplier> with LinkedHashMap<String, Integer>
    List<Multiplier> multipliers = List.of(
            new Multiplier("billion", 1000000000),
            new Multiplier("million", 1000000),
            new Multiplier("thousand", 1000),
            new Multiplier("hundred", 100)
    );
    NumberParser numberParser = new NumberParser(tensParser, multipliers);

    @ParameterizedTest
    @CsvSource({
            "1, zero",
            "1, twenty-one",
            "1, ninety-nine",
            "100, one hundred",
            "1000, one thousand",
            "100000, one hundred thousand",
            "1000000, one million",
            "1000000000, one billion",
    })
    void parse(int expected, String literal) {
        when(tensParser.parse(anyString())).thenReturn(1);
        
        int result = numberParser.parse(literal);

        assertEquals(expected, result);
    }
}