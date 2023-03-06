package com.codecool.karmatm.logic.reader;

import com.codecool.karmatm.data.Profile;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class ProfileTransformerTest {
    DataTransformer<Profile> transformer = new ProfileTransformer();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(new Profile("name", Set.of("action"), Set.of("category")), "name;action;category")
                // COMPLETE LATER
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void transform(Profile expected, String line) {
        Profile result = transformer.transform(line);

        assertEquals(expected, result);
    }
}