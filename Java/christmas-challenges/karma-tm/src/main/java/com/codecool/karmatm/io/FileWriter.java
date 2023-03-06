package com.codecool.karmatm.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriter {
    public void write(String path, List<String> lines) {
        try {
            doWrite(path, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doWrite(String path, List<String> lines) throws IOException {
        Files.write(Paths.get(path), lines, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }
}
