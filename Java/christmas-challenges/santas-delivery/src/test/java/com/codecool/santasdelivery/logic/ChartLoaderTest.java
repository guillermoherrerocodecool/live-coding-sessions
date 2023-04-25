package com.codecool.santasdelivery.logic;

import com.codecool.santasdelivery.data.Chart;
import com.codecool.santasdelivery.io.FileReader;
import com.codecool.santasdelivery.logic.chart.ChartLoader;
import com.codecool.santasdelivery.logic.chart.ChartValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Arrays.deepEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.mockito.Mockito.*;

class ChartLoaderTest {
    FileReader fileReader = mock(FileReader.class);
    ChartValidator chartValidator = mock(ChartValidator.class);
    ChartLoader chartLoader = new ChartLoader(fileReader, chartValidator);
    String input_path = "test";

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(new String[][]{}, Stream.empty()),
                of(new String[][]{new String[]{""}}, Stream.of("")),
                of(new String[][]{new String[]{"1"}}, Stream.of("1")),
                of(new String[][]{new String[]{"1", "2"}}, Stream.of("12")),
                of(new String[][]{new String[]{"1", "2"},
                        new String[]{"3", "4"}}, Stream.of("12", "34"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void loadValidated(String[][] expectedTiles, Stream<String> lines) {
        when(fileReader.read(input_path))
                .thenReturn(lines);

        Chart chart = chartLoader.load(input_path);
        String[][] resultTiles = chart.tiles();

        assertTrue(deepEquals(expectedTiles, resultTiles));
        verify(fileReader).read(input_path);
        verify(chartValidator).validate(any(Chart.class));
    }

    @Test
    void loadNotValidated() {
        Stream<String> lines = Stream.empty();
        when(fileReader.read(input_path))
                .thenReturn(lines);

        doThrow(IllegalStateException.class)
                .when(chartValidator).validate(any(Chart.class));

        assertThrows(IllegalStateException.class, () -> chartLoader.load(input_path));
        verify(chartValidator).validate(any(Chart.class));
    }
}