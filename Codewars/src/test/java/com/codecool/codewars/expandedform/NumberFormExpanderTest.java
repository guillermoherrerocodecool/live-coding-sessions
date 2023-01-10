package com.codecool.codewars.expandedform;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class NumberFormExpanderTest {
    
    NumberFormExpander expander = new NumberFormExpander();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of("1", 1),
                of("2", 2),
                of("10", 10),
                of("10 + 1", 11),
                of("10 + 9", 19),
                of("20 + 1", 21),
                of("100 + 1", 101),
                of("100 + 10 + 1", 111),
                of("70000 + 300 + 4", 70304)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void expand(String expected, int number){
        String result = expander.expand(number);

        assertEquals(expected, result);
    }

}