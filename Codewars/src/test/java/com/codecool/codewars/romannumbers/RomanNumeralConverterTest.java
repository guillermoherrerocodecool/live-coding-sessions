package com.codecool.codewars.romannumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class RomanNumeralConverterTest {

    private final List<RomanNumeralConverter.Swap> swaps = List.of(
            new RomanNumeralConverter.Swap("IIIII", "V"),
            new RomanNumeralConverter.Swap("IIII", "IV"),
            new RomanNumeralConverter.Swap("VV", "X"),
            new RomanNumeralConverter.Swap("VIV", "IX"),
            new RomanNumeralConverter.Swap("XXXXX", "L"),
            new RomanNumeralConverter.Swap("XXXX", "XL"),
            new RomanNumeralConverter.Swap("LL", "C"),
            new RomanNumeralConverter.Swap("LXL", "XC"),
            new RomanNumeralConverter.Swap("CCCCC", "D"),
            new RomanNumeralConverter.Swap("CCCC", "CD"),
            new RomanNumeralConverter.Swap("DD", "M"),
            new RomanNumeralConverter.Swap("DCD", "CM")
    );
    RomanNumeralConverter converter = new RomanNumeralConverter(swaps);

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of("I", 1),
                of("II", 2),
                of("III", 3),
                of("IV", 4),
                of("V", 5),
                of("VI", 6),
                of("VII", 7),
                of("VIII", 8),
                of("IX", 9),
                of("X", 10),
                of("XI", 11),
                of("L", 50),
                of("C", 100),
                of("CXCIX", 199),
                of("D", 500),
                of("M", 1000),
                of("MCMXC", 1990),
                of("MMVIII", 2008),
                of("MDCLXVI", 1666)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void convert(String expected, int number) {
        String result = converter.convert(number);

        assertEquals(expected, result);
    }
}