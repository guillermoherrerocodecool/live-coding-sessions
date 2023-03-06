package com.codecool.karmatm.logic.outcome;

import com.codecool.karmatm.data.Karma;
import com.codecool.karmatm.data.Outcome;
import com.codecool.karmatm.data.Profile;
import com.codecool.karmatm.logic.karma.KarmaCalculator;

import java.util.List;

public class OutcomeGenerator {
    private final KarmaCalculator karmaCalculator;

    public OutcomeGenerator(KarmaCalculator karmaCalculator) {
        this.karmaCalculator = karmaCalculator;
    }

    public List<Outcome> generate(List<Profile> profiles, List<Karma> karmas) {
        return profiles.stream()
                .map(profile -> transformToOutcome(profile, karmas))
                .toList();
    }

    private Outcome transformToOutcome(Profile profile, List<Karma> karmas) {
        return new Outcome(
                profile.name(),
                profile.actions(),
                karmaCalculator.calculate(profile.actions(), karmas),
                profile.idealPresentCategories()
        );
    }
}
