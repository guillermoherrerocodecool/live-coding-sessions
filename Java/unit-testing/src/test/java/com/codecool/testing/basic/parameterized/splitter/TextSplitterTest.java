package com.codecool.testing.basic.parameterized.splitter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.params.provider.Arguments.*;

class TextSplitterTest {
    TextSplitter splitter = new TextSplitter();

    // 80% + 18% + 2% = 100% test coverage
    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(List.of(), null),
                of(List.of(""), ""),
                of(List.of("a"), "a"),
                of(List.of(" "), " "),
                of(List.of(" ", " "), "  "),
                of(List.of("a", "b"), "ab"),
                of(List.of("a", " ", "a"), "a a"),
                of(List.of("a", "!", "a"), "a!a"),
                of(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "0"), "1234567890")
        );
    }


    @ParameterizedTest
    @MethodSource("parameters")
    void split(List<String> expected, String text) {
        List<String> result = splitter.split(text);

        assertIterableEquals(expected, result);
    }
    
    @Test
    void doSplit(){
        String text = "ab";

        String[] result = splitter.doSplit(text);

        String[] expected = {"a", "b"};
        assertArrayEquals(expected, result);
    }
}