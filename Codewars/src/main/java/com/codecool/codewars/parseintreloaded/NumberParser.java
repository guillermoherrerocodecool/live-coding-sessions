package com.codecool.codewars.parseintreloaded;

import com.codecool.codewars.parseintreloaded.multiplier.Multiplier;
import com.codecool.codewars.parseintreloaded.tens.TensParser;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class NumberParser {
    private final TensParser tensParser;
    private final List<Multiplier> multipliers;

    public NumberParser(TensParser tensParser, List<Multiplier> multipliers) {
        this.tensParser = tensParser;
        this.multipliers = multipliers;
    }

    public int parse(String literal) {
        literal = literal.replaceAll(" and ", " ");
        return parse(literal, new LinkedList<>(multipliers));
    }

    private int parse(String literal, Queue<Multiplier> multipliers) {
        if (multipliers.isEmpty()) {
            return tensParser.parse(literal);
        }
        Multiplier multiplier = multipliers.poll();
        if (!literal.contains(multiplier.name())) {
            return parse(literal, multipliers);
        }
        String[] parts = Stream.of(literal.split(multiplier.name(), 2)).map(String::trim).toArray(String[]::new);
        if (literal.endsWith(multiplier.name())) {
            return multiplier.number() * parse(parts[0], multipliers);
        }
        int left = multiplier.number() * parse(parts[0], new LinkedList<>(multipliers));
        int right = parse(parts[1], new LinkedList<>(multipliers));
        return left + right;
    }
}
