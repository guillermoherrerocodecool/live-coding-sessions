package com.codecool.codewars.parseintreloaded.tens;

import java.util.List;
import java.util.stream.Stream;

public class TensParser {
    private final List<Converter> converters;

    public TensParser(List<Converter> converters) {
        this.converters = converters;
    }

    public int parse(String literal) {
        return parse(literal.split("-"));
    }

    private int parse(String[] literals) {
        return Stream.of(literals)
                .mapToInt(this::convert)
                .sum();
    }

    private int convert(String numeral) {
        return converters.stream()
                .filter(converter -> converter.matches(numeral))
                .map(converter -> converter.convert(numeral))
                .findFirst()
                .orElseThrow();
    }
}
