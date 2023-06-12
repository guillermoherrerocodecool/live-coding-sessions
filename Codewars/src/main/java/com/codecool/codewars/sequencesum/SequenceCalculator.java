package com.codecool.codewars.sequencesum;

import java.util.stream.IntStream;

public class SequenceCalculator {
    public int sumSequence(int start, int end, int step) {
        return IntStream.iterate(start, number -> number <= end, number -> number + step)
                .sum();
    }
}
