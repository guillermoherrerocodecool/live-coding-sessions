package com.codecool.codewars.ascenddescendrepeat;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class UpDownStringGenerator {
    public String generate(int length, int minimum, int maximum) {
        if (minimum > maximum) {
            return "";
        }
        AtomicInteger current = new AtomicInteger(minimum);
        AtomicInteger factor = minimum == maximum ? new AtomicInteger(0) : new AtomicInteger(1);
        return IntStream.generate(() -> current.getAndSet(current.get() + factor.get()))
                .peek(update(factor, current, minimum, maximum))
                .mapToObj(String::valueOf)
                .map(characters -> characters.split(""))
                .flatMap(Stream::of)
                .limit(length)
                .collect(joining());
    }

    private IntConsumer update(AtomicInteger factor, AtomicInteger current, int minimum, int maximum) {
        return n -> {
            if (current.get() == minimum || current.get() == maximum) {
                factor.set(factor.get() * -1);
            }
        };
    }
}
