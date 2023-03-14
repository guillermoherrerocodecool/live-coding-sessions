package com.codecool.idealpresent.logic.profiles;

import com.codecool.idealpresent.data.Profile;
import com.codecool.idealpresent.io.FileWriter;

public class ProfilesWriter {
    private final FileWriter fileWriter;

    public ProfilesWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void write(String outputPath, Profile profile) {
        fileWriter.append(outputPath, toText(profile));
    }

    private String toText(Profile profile) {
        return "%s;%s;%s;%s;%s".formatted(
                profile.name(),
                String.join(",", profile.actions()),
                String.valueOf(profile.karma()),
                String.join(",", profile.categories()),
                String.join(",", profile.presents())
        );
    }
}
