package com.codecool.codewars.mergearray;

import java.util.stream.IntStream;

public class ArrayMerger {
    public int[] merge(int[] array1, int[] array2) {
        return IntStream.concat(IntStream.of(array1), IntStream.of(array2))
                .sorted()
                .distinct()
                .toArray();
    }
}
