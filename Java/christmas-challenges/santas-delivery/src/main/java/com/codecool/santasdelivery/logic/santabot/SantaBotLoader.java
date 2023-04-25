package com.codecool.santasdelivery.logic.santabot;

import com.codecool.santasdelivery.data.Chart;
import com.codecool.santasdelivery.data.Position;
import com.codecool.santasdelivery.data.SantaBot;

import java.util.List;
import java.util.stream.IntStream;

public class SantaBotLoader {
    private final String headquarters;

    public SantaBotLoader(String headquarters) {
        this.headquarters = headquarters;
    }

    public SantaBot load(Chart chart) {
        Position headquarters = findHeadquartersPosition(chart);
        return new SantaBot(headquarters);
    }

    private Position findHeadquartersPosition(Chart chart) {
        return IntStream.range(0, chart.tiles().length)
                .mapToObj(x -> IntStream.range(0, chart.tiles().length).mapToObj(y -> new Position(x, y)).toList())
                .flatMap(List::stream)
                .filter(position -> chart.tiles()[position.x()][position.y()].equals(headquarters))
                .findFirst()
                .get();
    }
}
