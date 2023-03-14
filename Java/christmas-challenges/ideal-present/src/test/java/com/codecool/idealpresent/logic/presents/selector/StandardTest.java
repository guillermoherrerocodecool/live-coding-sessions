package com.codecool.idealpresent.logic.presents.selector;

import com.codecool.idealpresent.data.Profile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class StandardTest {
    int threshold = 0;
    String present = "present";
    Selector selector = new Standard(threshold, present);

    @ParameterizedTest
    @CsvSource({
            "false, 0",
            "false, 1",
            "true, -1",
            "true, -2",
    })
    void matches(boolean expected, int karma) {
        Profile profile = new Profile("name", Set.of(), karma, Set.of(), Set.of());

        boolean result = selector.matches(profile);

        assertEquals(expected, result);
    }

    @Test
    void getPresents() {
        Profile profile = new Profile("name", Set.of(), 0, Set.of(), Set.of());

        Set<String> result = selector.getPresents(profile);

        Set<String> expected = Set.of(present);
        assertIterableEquals(expected, result);
    }
}