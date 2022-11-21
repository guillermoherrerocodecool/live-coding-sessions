package com.codecool.codewars.similarpassword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class SimilarPasswordOperatorTest {
    SimilarPasswordOperator operator = new SimilarPasswordOperator();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(0, "ab"),
                of(0, "ba"),
                of(1, "aa"),
                of(1, "bb"),
                of(2, "cc"),
                of(1, "abcd"),
                of(1, "hack"),
                of(3, "aaaeee"),
                of(3, "bbbccc"),
                of(4, "cccc"),
                of(0, "az"),
                of(5, "zz"),
                of(10, "zzzz")
        );
    }

    public static Stream<Arguments> determineTargetParameters() {
        return Stream.of(
                of(Target.SIMILAR, new String[]{"a", "b"}),
                of(Target.SIMILAR, new String[]{"b", "a"}),
                of(Target.CONSONANTS, new String[]{"a", "a"}),
                of(Target.VOWELS, new String[]{"b", "b"})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findMinimumNumberOfOperations(int expected, String password) {
        int result = operator.findMinimumNumberOfOperations(password);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("determineTargetParameters")
    void determineTarget(Target expected, String[] letters) {
        Target result = operator.determineTarget(letters);

        assertEquals(expected, result);
    }
}