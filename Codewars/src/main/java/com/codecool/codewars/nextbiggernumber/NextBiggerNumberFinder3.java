package com.codecool.codewars.nextbiggernumber;

import java.util.Arrays;

public class NextBiggerNumberFinder3 {
    public long find(long number) {
        char[] digits = String.valueOf(number).toCharArray();
        for (int current = digits.length - 2; current >= 0; current--) {
            for (int previous = digits.length - 1; previous > current; previous--) {
                if (digits[current] < digits[previous]) {
                    char temporary = digits[current];
                    digits[current] = digits[previous];
                    digits[previous] = temporary;
                    Arrays.sort(digits, current + 1, digits.length);
                    return Long.parseLong(String.valueOf(digits));
                }
            }
        }
        return -1;
    }
}
