package com.codecool.codewars.sortandstar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SorterTest {
    Sorter sorter = new Sorter();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{}, new String[]{}),
                Arguments.of(new String[]{"a" }, new String[]{"a" }),
                Arguments.of(new String[]{"a", "b" }, new String[]{"a", "b" }),
                Arguments.of(new String[]{"A", "B" }, new String[]{"A", "B" }),
                Arguments.of(new String[]{"a", "b" }, new String[]{"b", "a" }),
                Arguments.of(new String[]{"A", "B" }, new String[]{"B", "A" }),
                Arguments.of(new String[]{"B", "a" }, new String[]{"B", "a" })
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void sort(String[] expected, String[] strings) {
        String[] result = sorter.sort(strings);

        Assertions.assertArrayEquals(expected, result);
    }
}