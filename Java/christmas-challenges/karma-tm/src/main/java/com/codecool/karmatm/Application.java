package com.codecool.karmatm;

import com.codecool.karmatm.io.FileReader;
import com.codecool.karmatm.io.FileWriter;
import com.codecool.karmatm.logic.KarmaTM;
import com.codecool.karmatm.logic.karma.KarmaCalculator;
import com.codecool.karmatm.logic.outcome.OutcomeGenerator;
import com.codecool.karmatm.logic.outcome.OutcomeWriter;
import com.codecool.karmatm.logic.reader.DataReader;
import com.codecool.karmatm.logic.reader.KarmaTransformer;
import com.codecool.karmatm.logic.reader.ProfileTransformer;

public class Application {
    public static void main(String[] args) {
        String profilesPath = "src/main/resources/profiles.csv";
        String karmaPath = "src/main/resources/karma.csv";
        String outputPath = "src/main/resources/challenge-1.csv";
        FileReader fileReader = new FileReader();
        DataReader dataReader = new DataReader(fileReader);
        ProfileTransformer profileTransfomer = new ProfileTransformer();
        KarmaTransformer karmaTransfomer = new KarmaTransformer();
        KarmaCalculator karmaCalculator = new KarmaCalculator();
        OutcomeGenerator outcomeGenerator = new OutcomeGenerator(karmaCalculator);
        FileWriter fileWriter = new FileWriter();
        OutcomeWriter outcomeWriter = new OutcomeWriter(fileWriter);
        KarmaTM karmaTM = new KarmaTM(dataReader, profileTransfomer, karmaTransfomer, outcomeGenerator, outcomeWriter);
        karmaTM.evaluate(profilesPath, karmaPath, outputPath);
    }
}
