package com.codecool.santasdelivery.logic.chart;

import com.codecool.santasdelivery.data.Chart;

import java.util.Arrays;

public class ChartValidator {
    private final String headquarters;

    public ChartValidator(String headquarters) {
        this.headquarters = headquarters;
    }

    public void validate(Chart chart) {
        validateIsNotEmpty(chart);
        validateHasHeadquarters(chart);
    }

    private void validateIsNotEmpty(Chart chart) {
        if (chart.tiles().length == 0) {
            throw new IllegalStateException("Tiles are empty");
        }
    }

    private void validateHasHeadquarters(Chart chart) {
        if (doesNotContainH(chart)) {
            throw new IllegalStateException("Headquarters not found");
        }
    }

    private boolean doesNotContainH(Chart chart) {
        return Arrays.stream(chart.tiles())
                .flatMap(Arrays::stream)
                .noneMatch(letter -> letter.equals(headquarters));
    }
}
