package com.codecool.codewars.wordspin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordSpinner2Test {
    int minimumWordLength = 5;
    WordSpinner2 spinner = new WordSpinner2(minimumWordLength);

    @ParameterizedTest
    @CsvSource({
            "'', ''",
            "1, 1",
            "1234, 1234",
            "54321, 12345",
            "1 54321, 1 12345",
            "54321 12, 12345 12",
            "This is a test, This is a test",
            "emocleW, Welcome",
            "Hey wollef sroirraw, Hey fellow warriors",
    })
    void spin(String expected, String words) {
        String result = spinner.spin(words);

        assertEquals(expected, result);
    }
}