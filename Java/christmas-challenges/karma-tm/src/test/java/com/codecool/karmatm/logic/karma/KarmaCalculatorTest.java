package com.codecool.karmatm.logic.karma;

import com.codecool.karmatm.data.Karma;
import com.codecool.karmatm.logic.karma.KarmaCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static com.codecool.karmatm.data.ActionType.NAUGHTY;
import static com.codecool.karmatm.data.ActionType.NICE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class KarmaCalculatorTest {
    KarmaCalculator karmaCalculator = new KarmaCalculator();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(0, Set.of(), List.of()),
                of(0, Set.of("action"), List.of()),
                of(0, Set.of(), List.of(new Karma("test", NICE))),
                of(0, Set.of("action"), List.of(new Karma("test", NICE))),
                of(1, Set.of("action"), List.of(new Karma("action", NICE))),
                of(-1, Set.of("action"), List.of(new Karma("action", NAUGHTY))),
                of(1, Set.of("action1", "action2"),
                        List.of(new Karma("action1", NICE), new Karma("action3", NICE))),
                of(2, Set.of("action1", "action2"),
                        List.of(new Karma("action1", NICE), new Karma("action2", NICE))),
                of(-2, Set.of("action1", "action2"),
                        List.of(new Karma("action1", NAUGHTY), new Karma("action2", NAUGHTY))),
                of(0, Set.of("action1", "action2"),
                        List.of(new Karma("action1", NICE), new Karma("action2", NAUGHTY))),
                of(0, Set.of("action1", "action2"),
                        List.of(new Karma("action1", NAUGHTY), new Karma("action2", NICE)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(int expected, Set<String> actions, List<Karma> karmas) {
        int result = karmaCalculator.calculate(actions, karmas);

        assertEquals(expected, result);
    }
}