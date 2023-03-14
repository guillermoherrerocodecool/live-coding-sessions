package com.codecool.idealpresent.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriter {
    public void append(String path, String text) {
        try {
            doAppend(path, text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doAppend(String path, String text) throws IOException {
        String line = text + "\n";
        Files.writeString(Paths.get(path), line, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
