package com.codecool.santasdelivery.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public Stream<String> read(String input_path) {
        try {
            return doRead(input_path);
        } catch (IOException e) {
            throw new IllegalStateException("Could not read file: "+ input_path, e);
        }
    }

    private Stream<String> doRead(String input_path) throws IOException {
        return Files.lines(Paths.get(input_path));
    }
}
