package com.codecool.codewars.piglatin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class PigLatinConverterTest {
    PigLatinConverter converter = new PigLatinConverter();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of("", ""),
                of("!", "!"),
                of("aay", "a"),
                of("Aay", "A"),
                of("aay!", "a!"),
                of("aay, bay", "a, b"),
                of("baay", "ab"),
                of("bcaay", "abc"),
                of("BcAay", "ABc"),
                of("baay cbay!", "ab bc!"),
                of("bcaay, efday!", "abc, def!"),
                of("elloHay orldway !", "Hello world !"),
                of("igPay atinlay siay oolcay", "Pig latin is cool"),
                of("hisTay siay ymay tringsay", "This is my string"),
                of("baay!dcay", "ab!cd"),
                of(" baay!  dcay   ", " ab!  cd   ")
                );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void convert(String expected, String text) {
        String result = converter.convert(text);

        assertEquals(expected, result);
    }
}