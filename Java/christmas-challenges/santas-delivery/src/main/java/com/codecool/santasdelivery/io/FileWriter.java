package com.codecool.santasdelivery.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriter {
    public void write(List<String> lines, String output_path) {
        try {
            doWrite(lines, output_path);
        } catch (IOException e) {
            throw new IllegalStateException("Could not write file: " + output_path, e);
        }
    }

    private void doWrite(List<String> lines, String output_path) throws IOException {
        Files.write(Paths.get(output_path), lines, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
    }
}
