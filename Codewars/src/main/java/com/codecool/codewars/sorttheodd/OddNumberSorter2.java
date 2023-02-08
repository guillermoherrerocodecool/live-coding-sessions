package com.codecool.codewars.sorttheodd;

import java.util.Arrays;
import java.util.stream.IntStream;

public class OddNumberSorter2 {
    public int[] sort(int[] numbers) {
        int[] result = Arrays.copyOf(numbers, numbers.length);
        int[] odds = collectOddNumbersSorted(result);
        replace(odds, result);
        return result;
    }

    private int[] collectOddNumbersSorted(int[] result) {
        return IntStream.of(result)
                .filter(this::isOdd)
                .sorted()
                .toArray();
    }

    private boolean isOdd(int number) {
        return number % 2 == 1;
    }

    private void replace(int[] odds, int[] result) {
        int oddIndex = 0;
        for (int index = 0; index < result.length; index++) {
            int number = result[index];
            if (isOdd(number)) {
                result[index] = odds[oddIndex++];
            }
        }
    }
}
