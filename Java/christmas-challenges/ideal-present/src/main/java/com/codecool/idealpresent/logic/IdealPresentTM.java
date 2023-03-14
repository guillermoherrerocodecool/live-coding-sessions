package com.codecool.idealpresent.logic;

import com.codecool.idealpresent.logic.presents.PresentsEngine;
import com.codecool.idealpresent.logic.profiles.ProfilesReader;
import com.codecool.idealpresent.logic.profiles.ProfilesWriter;

public class IdealPresentTM {
    private final ProfilesReader profilesReader;
    private final PresentsEngine presentsEngine;
    private final ProfilesWriter profilesWriter;

    public IdealPresentTM(ProfilesReader profilesReader, PresentsEngine presentsEngine, ProfilesWriter profilesWriter) {
        this.profilesReader = profilesReader;
        this.presentsEngine = presentsEngine;
        this.profilesWriter = profilesWriter;
    }

    public void evaluate(String profilesPath, String outputPath) {
        profilesReader.read(profilesPath)
                .map(presentsEngine::matchPresents)
                .forEach(profile -> profilesWriter.write(outputPath, profile));
    }
}
