package com.codecool.karmatm.logic.outcome;

import com.codecool.karmatm.data.Karma;
import com.codecool.karmatm.data.Outcome;
import com.codecool.karmatm.data.Profile;
import com.codecool.karmatm.logic.karma.KarmaCalculator;
import com.codecool.karmatm.logic.outcome.OutcomeGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.mockito.Mockito.mock;

class OutcomeGeneratorTest {
    KarmaCalculator karmaCalculator = mock(KarmaCalculator.class);
    OutcomeGenerator outcomeGenerator = new OutcomeGenerator(karmaCalculator);

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(List.of(), List.of()),
                of(List.of(new Outcome("name", Set.of("action"), 0, Set.of("category"))),
                        List.of(new Profile("name", Set.of("action"), Set.of("category")))),
                of(List.of(new Outcome("name", Set.of("action1", "action2"), 0, Set.of("category"))),
                        List.of(new Profile("name", Set.of("action1", "action2"), Set.of("category")))),
                of(List.of(new Outcome("name", Set.of("action"), 0, Set.of("category1", "category2"))),
                        List.of(new Profile("name", Set.of("action"), Set.of("category1", "category2")))),
                of(List.of(new Outcome("name", Set.of("action1", "action2"), 0, Set.of("category1", "category2"))),
                        List.of(new Profile("name", Set.of("action1", "action2"), Set.of("category1", "category2"))))

                );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void generate(List<Outcome> expected, List<Profile> profiles) {
        List<Karma> karmas = List.of();

        List<Outcome> result = outcomeGenerator.generate(profiles, karmas);

        assertIterableEquals(expected, result);
    }
}