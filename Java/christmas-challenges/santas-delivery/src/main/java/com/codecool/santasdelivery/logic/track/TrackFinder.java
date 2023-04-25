package com.codecool.santasdelivery.logic.track;

import com.codecool.santasdelivery.data.Chart;
import com.codecool.santasdelivery.data.Position;
import com.codecool.santasdelivery.data.SantaBot;
import com.codecool.santasdelivery.data.Track;
import com.codecool.santasdelivery.logic.santabotengine.SantaBotEngine;

import java.util.ArrayList;
import java.util.List;

public class TrackFinder {
    private final SantaBotEngine santaBotEngine;

    public TrackFinder(SantaBotEngine santaBotEngine) {
        this.santaBotEngine = santaBotEngine;
    }

    public Track find(SantaBot santaBot, Chart chart) {
        return new Track(findTrackPositions(santaBot, chart));
    }

    private List<Position> findTrackPositions(SantaBot santaBot, Chart chart) {
        Position headquarters = santaBot.getPosition();
        List<Position> positions = new ArrayList<>();
        do {
            findNextTrackPosition(santaBot, chart, positions);
        } while (isSantaBotNotBack(santaBot, headquarters));
        return positions;
    }

    private void findNextTrackPosition(SantaBot santaBot, Chart chart, List<Position> positions) {
        santaBotEngine.move(santaBot, chart);
        Position position = santaBot.getPosition();
        positions.add(position);
    }

    private boolean isSantaBotNotBack(SantaBot santaBot, Position headquarters) {
        return !santaBot.getPosition().equals(headquarters);
    }
}
