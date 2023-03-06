package com.codecool.karmatm.logic.reader;

import com.codecool.karmatm.data.Profile;

import java.util.Set;

public class ProfileTransformer implements DataTransformer<Profile> {
    
    @Override
    public Profile transform(String line) {
        String[] columns = line.split(";");
        return new Profile(
                columns[0],
                parseToSet(columns[1]),
                parseToSet(columns[2])
        );
    }

    private Set<String> parseToSet(String column) {
        return Set.of(column.split(","));
    }
}
