package com.codecool.codewars.mexicanweave;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class MexicanWeaveGeneratorTest {
    MexicanWeaveGenerator simulator = new MexicanWeaveGenerator();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(new String[]{}, ""),
                of(new String[]{"A"}, "a"),
                of(new String[]{"Ab", "aB"}, "ab"),
                of(new String[]{"A b", "a B"}, "a b"),
                of(new String[]{"A  b", "a  B"}, "a  b"),
                of(new String[]{" A  b", " a  B"}, " a  b"),
                of(new String[]{
                        "Two words", "tWo words", "twO words", "two Words",
                        "two wOrds", "two woRds", "two worDs", "two wordS"
                }, "two words"),
                of(new String[]{" Gap ", " gAp ", " gaP "}, " gap ")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void simulate(String[] expected, String text) {
        String[] result = simulator.generate(text);

        assertArrayEquals(expected, result);
    }
}