package com.codecool.karmatm.logic.reader;

import com.codecool.karmatm.data.Karma;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codecool.karmatm.data.ActionType.NAUGHTY;
import static com.codecool.karmatm.data.ActionType.NICE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;

class KarmaTransformerTest {
    DataTransformer<Karma> transformer = new KarmaTransformer();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(new Karma("action", NICE), "nice;action"),
                of(new Karma("action", NICE), "niCE;action"),
                of(new Karma("action", NICE), "NICE;action"),
                of(new Karma("action", NAUGHTY), "naughty;action"),
                of(new Karma("action", NAUGHTY), "NAughty;action"),
                of(new Karma("action", NAUGHTY), "NAUGHTY;action")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void transform(Karma expected, String line) {
        Karma result = transformer.transform(line);

        assertEquals(expected, result);
    }

    @Test
    void transformDoesNotFindProperActionType() {
        String line = "wrong-type;action";
        assertThrows(IllegalArgumentException.class, () -> transformer.transform(line));
    }
}