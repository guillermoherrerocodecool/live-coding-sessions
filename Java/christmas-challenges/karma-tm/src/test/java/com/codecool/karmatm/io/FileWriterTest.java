package com.codecool.karmatm.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class FileWriterTest {
    FileWriter fileWriter = new FileWriter();
    FileReader fileReader = new FileReader();
    String path = "src/test/resources/file-writer-test.txt";

    @AfterEach
    void after() throws IOException {
        Files.deleteIfExists(Paths.get(path));
    }

    @Test
    void write() {
        List<String> lines = List.of("line 1", "line 2");

        fileWriter.write(path, lines);

        List<String> result = fileReader.read(path).toList();
        assertIterableEquals(lines, result);
    }
}