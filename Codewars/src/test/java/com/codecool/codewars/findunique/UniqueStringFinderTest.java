package com.codecool.codewars.findunique;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;

class UniqueStringFinderTest {
    UniqueStringFinder finder = new UniqueStringFinder();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of("a", new String[]{"a", "b", "b"}),
                of("a", new String[]{"b", "a", "b"}),
                of("a", new String[]{"b", "b", "a"}),
                of("a", new String[]{"b", "b ", "a"}),
                of("a", new String[]{"b", " b", "a"}),
                of("a", new String[]{"b", " b ", "a"}),
                of("a", new String[]{"b", " b    ", "a"}),
                of("a", new String[]{"bb", "bb", "a"}),
                of("a", new String[]{"bb ", " b  b  ", "a"}),
                of("a", new String[]{"abc ", " a  b       c ", "a"})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void find(String expected, String[] strings) {
        String result = finder.find(strings);

        assertEquals(expected, result);
    }

    @Test
    void findReceivesInputWithoutSingleUniqueString() {
        String[] strings = {"a", "a", "b", "b"};

        assertThrows(NoSuchElementException.class, () -> finder.find(strings));
    }
}