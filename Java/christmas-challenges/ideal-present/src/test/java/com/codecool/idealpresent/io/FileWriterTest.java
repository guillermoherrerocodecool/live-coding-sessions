package com.codecool.idealpresent.io;

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
        String line = "line";
        
        fileWriter.append(path, line);

        List<String> expected = List.of(line);
        List<String> result = fileReader.read(path).toList();
        assertIterableEquals(expected, result);

        fileWriter.append(path, line);

        expected = List.of(line, line);
        result = fileReader.read(path).toList();
        assertIterableEquals(expected, result);
    }
}