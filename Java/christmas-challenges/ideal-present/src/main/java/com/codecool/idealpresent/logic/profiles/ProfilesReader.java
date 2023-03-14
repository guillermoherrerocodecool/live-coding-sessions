package com.codecool.idealpresent.logic.profiles;

import com.codecool.idealpresent.data.Profile;
import com.codecool.idealpresent.io.FileReader;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ProfilesReader {
    private final FileReader fileReader;

    public ProfilesReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public Stream<Profile> read(String profilesPath) {
        return fileReader.read(profilesPath)
                .map(line -> line.split(";"))
                .map(this::toProfile);
    }

    private Profile toProfile(String[] columns) {
        return new Profile(
                columns[0],
                Set.of(columns[1].split(",")),
                Integer.parseInt(columns[2]),
                Set.of(columns[3].split(",")),
                new HashSet<>()
        );
    }
}
