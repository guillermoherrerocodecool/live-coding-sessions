package com.codecool.testing.basic.parameterized.splitter;

import java.util.List;
import java.util.stream.Stream;

public class TextSplitter {
    public List<String> split(String text) {
        if (text == null) {
            return List.of();
        }
        return Stream.of(doSplit(text)).toList();
    }

    String[] doSplit(String text) {
        return text.split("");
    }
}
