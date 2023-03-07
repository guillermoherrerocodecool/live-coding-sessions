package com.codecool.codewars.parseintreloaded.tens;

import java.util.Map;
import java.util.function.Function;

public class Converter {
    private final Map<String, Integer> translations;
    private final String ending;
    private final Function<Integer, Integer> operation;

    public Converter(Map<String, Integer> translations, String ending, Function<Integer, Integer> operation) {
        this.translations = translations;
        this.ending = ending;
        this.operation = operation;
    }

    public boolean matches(String numeral) {
        return numeral.endsWith(ending);
    }

    public int convert(String numeral) {
        String processed = numeral.replace(ending, "");
        int converted = translations.get(processed);
        return operation.apply(converted);
    }
}
