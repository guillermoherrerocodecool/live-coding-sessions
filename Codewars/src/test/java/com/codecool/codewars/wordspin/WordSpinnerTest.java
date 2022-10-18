package com.codecool.codewars.wordspin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class WordSpinnerTest {
    int minimumWordLengthToStartSpinning = 5;
    WordSpinner wordSpinner = new WordSpinner(minimumWordLengthToStartSpinning);

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of("", ""),
                of("", " "),
                of("a", "a"),
                of("a", " a"),
                of("a", " a  "),
                of("abcd", "abcd"),
                of("abcde", "edcba"),
                of("a a", "a a"),
                of("a abcde", "a edcba"),
                of("ab abcde ab", "ab edcba ab"),
                of("Hey wollef sroirraw", "Hey fellow warriors"),
                of("This is a test", "This is a test"),
                of("This is rehtona test", "This is another test")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void spin(String expected, String text) {
        String result = wordSpinner.spin(text);

        assertEquals(expected, result);
    }
}