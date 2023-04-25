package com.codecool.santasdelivery.logic.santabotengine;

import com.codecool.santasdelivery.data.Chart;
import com.codecool.santasdelivery.data.Position;
import com.codecool.santasdelivery.data.SantaBot;

public class Sequential implements SantaBotEngine {
    @Override
    public void move(SantaBot santaBot, Chart chart) {
        Position current = santaBot.getPosition();
        Position next = getNext(current, chart);
        santaBot.setPosition(next);
    }

    private Position getNext(Position current, Chart chart) {
        int length = chart.tiles().length;
        int nextY = current.y() + 1;
        int nextX = nextY != length ? current.x() : (current.x() + 1) % length;
        nextY = nextY % length;
        return new Position(nextX, nextY);
    }
}
