package com.codecool.codewars.goodvsevil;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class BattleEvaluatorTest {
    static String good = "Battle Result: Good triumphs over Evil";
    static String evil = "Battle Result: Evil eradicates all trace of Good";
    static String tie = "Battle Result: No victor on this battle field";

    int[] goodValues = new int[]{1, 2, 3, 3, 4, 10};
    int[] evilValues = new int[]{1, 2, 2, 2, 3, 5, 10};
    BattleEvaluator battleEvaluator = new BattleEvaluator(good, evil, tie, goodValues, evilValues);

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(tie, "0 0 0 0 0 0", "0 0 0 0 0 0 0"),
                of(tie, "1 0 0 0 0 0", "1 0 0 0 0 0 0"),
                of(tie, "0 1 0 0 0 0", "0 1 0 0 0 0 0"),
                of(tie, "0 1 0 0 0 0", "0 0 1 0 0 0 0"),
                of(tie, "0 1 0 0 0 0", "0 0 0 1 0 0 0"),
                of(tie, "0 0 1 0 0 0", "0 0 0 0 1 0 0"),
                of(tie, "0 1 0 1 0 0", "0 0 0 0 0 1 0"),
                of(tie, "0 0 0 0 0 1", "0 0 0 0 0 0 1"),
                of(good, "1 0 0 0 0 0", "0 0 0 0 0 0 0"),
                of(evil, "0 0 0 0 0 0", "1 0 0 0 0 0 0"),
                of(evil, "1 1 1 1 1 1", "1 1 1 1 1 1 1"),
                of(good, "0 0 0 0 0 10", "0 1 1 1 1 0 0"),
                of(good, "   0 0 0 0 0 10", "0 1 1 1 1 0 0     "),
                of(good, "   0  0    0  0 0   10  ", "   0  1  1 1   1 0 0     ")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void battle(String expected, String goodAmounts, String evilAmounts) {
        String result = battleEvaluator.evaluate(goodAmounts, evilAmounts);

        assertEquals(expected, result);
    }
}