package com.codecool.santasdelivery.logic.chart;

import com.codecool.santasdelivery.data.Chart;
import com.codecool.santasdelivery.io.FileReader;

import java.util.stream.Stream;

public class ChartLoader {
    private final FileReader fileReader;
    private final ChartValidator chartValidator; // done?

    public ChartLoader(FileReader fileReader, ChartValidator chartValidator) {
        this.fileReader = fileReader;
        this.chartValidator = chartValidator;
    }

    public Chart load(String input_path) {
        Stream<String> lines = fileReader.read(input_path);
        String[][] tiles = loadTiles(lines);
        Chart chart = new Chart(tiles);
        chartValidator.validate(chart);
        return chart;
    }

    private String[][] loadTiles(Stream<String> lines) {
        return lines.map(line -> line.split(""))
                .toArray(String[][]::new);
    }
}
