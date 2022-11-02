package com.codecool.codewars.goodvsevil;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BattleEvaluator {
    private final String good;
    private final String evil;
    private final String tie;
    private final int[] goodValues;
    private final int[] evilValues;

    public BattleEvaluator(String good, String evil, String tie, int[] goodValues, int[] evilValues) {
        this.good = good;
        this.evil = evil;
        this.tie = tie;
        this.goodValues = goodValues;
        this.evilValues = evilValues;
    }

    public String evaluate(String goodAmounts, String evilAmounts) {
        int goodWorth = calculateWorth(goodAmounts, goodValues);
        int evilWorth = calculateWorth(evilAmounts, evilValues);
        return determineResult(goodWorth, evilWorth);
    }

    private int calculateWorth(String amounts, int[] values) {
        int[] numbers = Stream.of(amounts.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return IntStream.range(0, numbers.length)
                .map(index -> numbers[index] * values[index])
                .sum();
    }

    private String determineResult(int goodWorth, int evilWorth) {
        int result = goodWorth - evilWorth;
        return result > 0 ? good :
                result < 0 ? evil :
                        tie;
    }
}
