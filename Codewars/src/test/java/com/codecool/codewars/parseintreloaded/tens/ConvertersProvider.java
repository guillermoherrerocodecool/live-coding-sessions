package com.codecool.codewars.parseintreloaded.tens;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertersProvider {
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
    private final List<Converter> converters = List.of(
            new Converter(translations, "ty", number -> number * 10),
            new Converter(translations, "teen", number -> number + 10),
            new Converter(translations, "", number -> number)
    );

    public List<Converter> getConverters() {
        return converters;
    }
}
