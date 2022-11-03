package com.codecool.codewars.mexicanweave;

import java.util.stream.IntStream;

public class MexicanWeaveGenerator {
    public String[] generate(String text) {
        return IntStream.range(0, text.length())
                .filter(index -> text.charAt(index) != ' ')
                .mapToObj(index -> uppercase(index, text))
                .toArray(String[]::new);
    }

    private String uppercase(int index, String text) {
        String target = String.valueOf(text.charAt(index));
        String head = text.substring(0, index);
        String body = target.toUpperCase();
        String tail = text.substring(index + 1);
        return head + body + tail;
    }
}
