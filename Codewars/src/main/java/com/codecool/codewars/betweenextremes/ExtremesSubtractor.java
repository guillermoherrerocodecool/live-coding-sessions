package com.codecool.codewars.betweenextremes;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class ExtremesSubtractor {
    public int subtractExtremes(int[] numbers) {
        IntSummaryStatistics statistics = IntStream.of(numbers).summaryStatistics();
        return statistics.getMax() - statistics.getMin();
    }
}
