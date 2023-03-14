package com.codecool.idealpresent.logic.presents;

import com.codecool.idealpresent.io.FileReader;

import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class PresentsLoader {
    private final FileReader fileReader;

    public PresentsLoader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public Map<String, Set<String>> load(String presentsPath) {
        return fileReader.read(presentsPath)
                .skip(1)
                .map(line -> line.split(";"))
                .collect(toMap(columns -> columns[0], columns -> Set.of(columns[1].split(","))));
    }
}
