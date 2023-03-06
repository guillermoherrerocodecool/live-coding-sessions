package com.codecool.karmatm.logic.reader;

import com.codecool.karmatm.io.FileReader;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DataReaderTest {
    FileReader fileReader = mock(FileReader.class);
    DataTransformer<Integer> dataTransformer = mock(DataTransformer.class);
    DataReader dataReader = new DataReader(fileReader);

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(List.of(), Stream.empty()),
                of(List.of(), Stream.of("header")),
                of(List.of(0), Stream.of("header", "line 1")),
                of(List.of(0, 0), Stream.of("header", "line 1", "line 2"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void read(List<Integer> expected, Stream<String> lines) {
        String path = "path";
        when(fileReader.read(path)).thenReturn(lines);
        when(dataTransformer.transform(anyString())).thenReturn(0);

        List<Integer> result = dataReader.read(path, dataTransformer);

        assertIterableEquals(expected, result);
    }
}