package com.codecool.codewars.pokerflush;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class PokerFlushCheckTest {
    PokerFlushCheck pokerFlushCheck = new PokerFlushCheck();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(false, new String[]{"1S", "1?", "1?", "1?", "1?"}),
                of(false, new String[]{"1S", "1S", "1?", "1?", "1?"}),
                of(false, new String[]{"1S", "1S", "1S", "1?", "1?"}),
                of(false, new String[]{"1S", "1S", "1S", "1S", "1?"}),
                of(true, new String[]{"1S", "1S", "1S", "1S", "1S"}),
                of(true, new String[]{"10S", "1S", "1S", "1S", "1S"})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void check(boolean expected, String[] cards) {
        boolean result = pokerFlushCheck.check(cards);

        assertEquals(expected, result);
    }
}