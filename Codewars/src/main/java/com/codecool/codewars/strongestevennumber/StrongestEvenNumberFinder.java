package com.codecool.codewars.strongestevennumber;

import java.util.Comparator;
import java.util.stream.IntStream;

public class StrongestEvenNumberFinder {
    public int findWithinInterval(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(this::isEven)
                .boxed()
                .sorted((n1, n2) -> strongness(n1) > strongness(n2) ? -1 : 1)
                .min(Comparator.naturalOrder())
                .orElseThrow();
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private int strongness(int number) {
        int strongness = 0;
        while (isEven(number)) {
            number /= 2;
            strongness++;
        }
        return strongness;
    }
}
