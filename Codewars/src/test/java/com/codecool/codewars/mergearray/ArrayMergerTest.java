package com.codecool.codewars.mergearray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class ArrayMergerTest {
    ArrayMerger merger = new ArrayMerger();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{}, new int[]{}, new int[]{}),
                of(new int[]{1}, new int[]{1}, new int[]{1}),
                of(new int[]{1, 2, 3}, new int[]{1, 3}, new int[]{1, 2}),
                of(new int[]{1, 2, 3, 4}, new int[]{1, 3}, new int[]{1, 2, 4}),
                of(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3}, new int[]{1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void merge(int[] expected, int[] array1, int[] array2) {
        int[] result = merger.merge(array1, array2);

        assertArrayEquals(expected, result);
    }
}