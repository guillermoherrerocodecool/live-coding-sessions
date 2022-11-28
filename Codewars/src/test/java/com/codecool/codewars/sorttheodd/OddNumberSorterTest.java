package com.codecool.codewars.sorttheodd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class OddNumberSorterTest {
    OddNumberSorter sorter = new OddNumberSorter();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{}, new int[]{}),
                of(new int[]{0}, new int[]{0}),
                of(new int[]{1}, new int[]{1}),
                of(new int[]{2}, new int[]{2}),
                of(new int[]{0, 0}, new int[]{0, 0}),
                of(new int[]{0, 1}, new int[]{0, 1}),
                of(new int[]{1, 0}, new int[]{1, 0}),
                of(new int[]{1, 1}, new int[]{1, 1}),
                of(new int[]{2, 1}, new int[]{2, 1}),
                of(new int[]{1, 7}, new int[]{7, 1}),
                of(new int[]{3, 8, 6, 5, 4}, new int[]{5, 8, 6, 3, 4}),
                of(new int[]{1, 8, 3, 6, 5, 4, 7, 2, 9, 0}, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void sort(int[] expected, int[] array) {
        int[] result = sorter.sort(array);

        assertArrayEquals(expected, result);
    }
}