package com.codecool.santasdelivery.logic.santabotengine;

import com.codecool.santasdelivery.data.Chart;
import com.codecool.santasdelivery.data.SantaBot;

public interface SantaBotEngine {
    void move(SantaBot santaBot, Chart chart);
}
