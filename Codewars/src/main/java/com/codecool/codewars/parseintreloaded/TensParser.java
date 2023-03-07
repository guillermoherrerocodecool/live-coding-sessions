package com.codecool.codewars.parseintreloaded;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class TensParser {
    private final Map<String, Integer> translations = new HashMap<>() {{
        put("zero", 0);
        put("one", 1);
        put("two", 2);
        put("three", 3);
        put("four", 4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight", 8);
        put("nine", 9);
        put("ten", 10);
        put("eleven", 11);
        put("twelve", 12);
        put("twen", 2);
        put("thir", 3);
        put("for", 4);
        put("fif", 5);
        put("eigh", 8);
    }};
    private final List<Function<String, Optional<Integer>>> transformations = List.of(
            number -> transform(number, "ty", n -> n * 10),
            number -> transform(number, "teen", n -> n + 10),
            number -> transform(number, "", n -> n));

    public int parse(String literal) {
        return parse(literal.split("-"));
    }

    private int parse(String[] literals) {
        return Stream.of(literals)
                .mapToInt(this::transform)
                .sum();
    }

    private int transform(String literal) {
        for (Function<String, Optional<Integer>> transformation : transformations) {
            Optional<Integer> oResult = transformation.apply(literal);
            if (oResult.isPresent()) {
                return oResult.get();
            }
        }
        throw new IllegalStateException("No transformation found for literal: " + literal);
    }

    private Optional<Integer> transform(String literal, String ending, Function<Integer, Integer> operation) {
        if (literal.endsWith(ending)) {
            String processed = literal.replace(ending, "");
            int converted = translations.get(processed);
            return Optional.of(operation.apply(converted));
        }
        return Optional.empty();
    }
}
