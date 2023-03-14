package com.codecool.idealpresent.io;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderTest {
    FileReader fileReader = new FileReader();
    String path = "src/test/resources/file-reader-test.txt";

    @Test
    void read() {
        List<String> result = fileReader.read(path).toList();

        List<String> expect = List.of("line 1", "line 2");
        assertIterableEquals(expect, result);
    }

    @Test
    void readDoesNotFindFile() {
        String wrongPath = "wrong-path";

        assertThrows(RuntimeException.class, () -> fileReader.read(wrongPath));
    }
}