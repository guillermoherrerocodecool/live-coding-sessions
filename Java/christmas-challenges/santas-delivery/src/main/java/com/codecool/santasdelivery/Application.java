package com.codecool.santasdelivery;

import com.codecool.santasdelivery.io.FileReader;
import com.codecool.santasdelivery.io.FileWriter;
import com.codecool.santasdelivery.logic.SantasDelivery;
import com.codecool.santasdelivery.logic.chart.ChartLoader;
import com.codecool.santasdelivery.logic.chart.ChartValidator;
import com.codecool.santasdelivery.logic.santabot.SantaBotLoader;
import com.codecool.santasdelivery.logic.santabotengine.SantaBotEngine;
import com.codecool.santasdelivery.logic.santabotengine.Sequential;
import com.codecool.santasdelivery.logic.track.TrackFinder;
import com.codecool.santasdelivery.logic.track.TrackWriter;

public class Application {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        String headquarters = "H";
        ChartValidator chartValidator = new ChartValidator(headquarters);
        ChartLoader chartLoader = new ChartLoader(fileReader, chartValidator);
        SantaBotLoader santaBotLoader = new SantaBotLoader(headquarters);
        SantaBotEngine santaBotEngine = new Sequential();
        TrackFinder trackFinder = new TrackFinder(santaBotEngine);
        FileWriter fileWriter = new FileWriter();
        TrackWriter trackWriter = new TrackWriter(fileWriter);
        SantasDelivery santasDelivery = new SantasDelivery(chartLoader, santaBotLoader, trackFinder, trackWriter);
        String input_path = "src/main/resources/planet.map";
        String output_path = "src/main/resources/santas-delivery.track";
        santasDelivery.deliver(input_path, output_path);
    }
}
