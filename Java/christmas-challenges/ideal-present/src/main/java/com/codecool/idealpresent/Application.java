package com.codecool.idealpresent;

import com.codecool.idealpresent.io.FileReader;
import com.codecool.idealpresent.io.FileWriter;
import com.codecool.idealpresent.logic.IdealPresentTM;
import com.codecool.idealpresent.logic.profiles.ProfilesReader;
import com.codecool.idealpresent.logic.profiles.ProfilesWriter;
import com.codecool.idealpresent.logic.presents.PresentsEngine;
import com.codecool.idealpresent.logic.presents.PresentsLoader;
import com.codecool.idealpresent.logic.presents.selector.OnePresent;
import com.codecool.idealpresent.logic.presents.selector.Selector;
import com.codecool.idealpresent.logic.presents.selector.SeveralPresents;
import com.codecool.idealpresent.logic.presents.selector.Standard;

import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        String profilesPath = "src/main/resources/challenge-1.csv";
        String presentsPath = "src/main/resources/presents.csv";
        String outputPath = "src/main/resources/challenge-2.csv";
        FileReader fileReader = new FileReader();
        ProfilesReader profilesReader = new ProfilesReader(fileReader);
        PresentsLoader presentsLoader = new PresentsLoader(fileReader);
        Map<String, Set<String>> presentsByCategory = presentsLoader.load(presentsPath);
        Random random = new Random();
        String standardPresent = "coal";
        int standardKarmaThreshold = 0;
        Selector standard = new Standard(standardKarmaThreshold, standardPresent);
        int exceptionalKarmaThreshold = 7;
        Selector onePresent = new OnePresent(standardKarmaThreshold, exceptionalKarmaThreshold, presentsByCategory, random);
        int numberOfPresents = 2;
        Selector severalPresents = new SeveralPresents(exceptionalKarmaThreshold, numberOfPresents, presentsByCategory, random);
        Set<Selector> selectors = Set.of(standard, onePresent, severalPresents);
        PresentsEngine presentsEngine = new PresentsEngine(selectors);
        FileWriter fileWriter = new FileWriter();
        ProfilesWriter profilesWriter = new ProfilesWriter(fileWriter);
        IdealPresentTM idealPresentTM = new IdealPresentTM(profilesReader, presentsEngine, profilesWriter);
        idealPresentTM.evaluate(profilesPath, outputPath);
    }
}
