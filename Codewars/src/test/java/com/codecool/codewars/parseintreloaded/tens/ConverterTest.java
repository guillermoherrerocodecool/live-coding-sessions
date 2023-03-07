package com.codecool.codewars.parseintreloaded.tens;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {
    Map<String, Integer> translations = Map.of(
            "one", 1,
            "two", 2
    );

    Converter converter = new Converter(translations, "ending", n -> n * 10);

    @ParameterizedTest
    @CsvSource({
            "false, test",
            "false, Ending",
            "true, ending",
    })
    void matches(boolean expected, String numeral) {
        boolean result = converter.matches(numeral);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "10, one",
            "20, two",
            "10, oneending",
            "20, twoending",
    })
    void convert(int expected, String numeral) {
        int result = converter.convert(numeral);

        assertEquals(expected, result);
    }
}