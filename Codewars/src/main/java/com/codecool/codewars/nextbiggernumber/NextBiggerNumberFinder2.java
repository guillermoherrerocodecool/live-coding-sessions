package com.codecool.codewars.nextbiggernumber;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NextBiggerNumberFinder2 {
    public long find(long number) {
        if (number < 10) {
            return -1;
        }
        long[] digits = Stream.of(String.valueOf(number).split(""))
                .mapToLong(Long::parseLong)
                .toArray();
        int smallerIndex = findSmallerIndex(digits);
        if (smallerIndex == -1) {
            return -1;
        }
        int biggerIndex = findImmediateBiggerThanSmallerIndex(digits, smallerIndex);
        swap(digits, smallerIndex, biggerIndex);
        Arrays.sort(digits, smallerIndex+1, digits.length);
        long biggerNumber = Long.parseLong(Arrays.stream(digits)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
        return biggerNumber > number ? biggerNumber : -1;
    }

    private int findSmallerIndex(long[] digits) {
        int last = digits.length - 1;
        long previous = digits[last];
        for (int index = last - 1; index >= 0; index--) {
            long current = digits[index];
            if (current < previous) {
                return index;
            }
            previous = current;
        }
        return -1;
    }

    private int findImmediateBiggerThanSmallerIndex(long[] digits, int smallerIndex) {
        long smallNumber = digits[smallerIndex];
        int biggerIndex = smallerIndex +1;
        long biggerNumber = digits[biggerIndex];
        for (int index = smallerIndex; index < digits.length; index++) {
            long current = digits[index];
            if (current > smallNumber && current < biggerNumber) {
                biggerNumber = current;
                biggerIndex = index;
            }
        }
        return biggerIndex;
    }

    private void swap(long[] digits, int smallerIndex, int biggerIndex) {
        long number = digits[smallerIndex];
        digits[smallerIndex] = digits[biggerIndex];
        digits[biggerIndex] = number;
    }
}
