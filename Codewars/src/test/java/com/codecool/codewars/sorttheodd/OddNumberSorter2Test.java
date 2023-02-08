package com.codecool.codewars.sorttheodd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class OddNumberSorter2Test {
    OddNumberSorter2 oddNumberSorter2 = new OddNumberSorter2();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{}, new int[]{}),
                of(new int[]{0}, new int[]{0}),
                of(new int[]{1}, new int[]{1}),
                of(new int[]{2}, new int[]{2}),
                of(new int[]{1, 2}, new int[]{1, 2}),
                of(new int[]{2, 1}, new int[]{2, 1}),
                of(new int[]{1, 3}, new int[]{3, 1}),
                of(new int[]{1, 2, 3}, new int[]{3, 2, 1}),
                of(new int[]{1, 3, 2, 8, 5, 4}, new int[]{5, 3, 2, 8, 1, 4}),
                of(new int[]{1, 3, 5, 8, 0}, new int[]{5, 3, 1, 8, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void sort(int[] expected, int[] numbers) {
        int[] result = oddNumberSorter2.sort(numbers);

        assertArrayEquals(expected, result);
    }
}