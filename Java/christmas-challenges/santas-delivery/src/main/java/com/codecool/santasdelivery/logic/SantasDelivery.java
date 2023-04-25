package com.codecool.santasdelivery.logic;

import com.codecool.santasdelivery.data.Chart;
import com.codecool.santasdelivery.data.SantaBot;
import com.codecool.santasdelivery.data.Track;
import com.codecool.santasdelivery.logic.track.TrackWriter;
import com.codecool.santasdelivery.logic.chart.ChartLoader;
import com.codecool.santasdelivery.logic.santabot.SantaBotLoader;
import com.codecool.santasdelivery.logic.track.TrackFinder;

public class SantasDelivery {
    private final ChartLoader chartLoader; // done (fileReader test!)
    private final SantaBotLoader santaBotLoader; // done
    private final TrackFinder trackFinder; // done
    private final TrackWriter trackWriter; // done? (fileWrite test!)

    public SantasDelivery(ChartLoader chartLoader, SantaBotLoader santaBotLoader, TrackFinder trackFinder, TrackWriter trackWriter) {
        this.chartLoader = chartLoader;
        this.santaBotLoader = santaBotLoader;
        this.trackFinder = trackFinder;
        this.trackWriter = trackWriter;
    }

    public void deliver(String input_path, String output_path) {
        Chart chart = chartLoader.load(input_path);
        SantaBot santaBot = santaBotLoader.load(chart);
        Track track = trackFinder.find(santaBot, chart);
        trackWriter.write(track, output_path);
    }
}
