package com.codecool.karmatm.logic;

import com.codecool.karmatm.data.Karma;
import com.codecool.karmatm.data.Outcome;
import com.codecool.karmatm.data.Profile;
import com.codecool.karmatm.logic.outcome.OutcomeGenerator;
import com.codecool.karmatm.logic.outcome.OutcomeWriter;
import com.codecool.karmatm.logic.reader.DataReader;
import com.codecool.karmatm.logic.reader.DataTransformer;

import java.util.List;

public class KarmaTM {
    private final DataReader dataReader;
    private final DataTransformer<Profile> profileTransfomer;
    private final DataTransformer<Karma> karmaTransfomer;
    private final OutcomeGenerator outcomeGenerator;
    private final OutcomeWriter outcomeWriter;

    public KarmaTM(DataReader dataReader, DataTransformer<Profile> profileTransfomer, DataTransformer<Karma> karmaTransfomer, OutcomeGenerator outcomeGenerator, OutcomeWriter outcomeWriter) {
        this.dataReader = dataReader;
        this.profileTransfomer = profileTransfomer;
        this.karmaTransfomer = karmaTransfomer;
        this.outcomeGenerator = outcomeGenerator;
        this.outcomeWriter = outcomeWriter;
    }
    
    public void evaluate(String profilesPath, String karmaPath, String outputPath) {
        List<Profile> profiles = dataReader.read(profilesPath, profileTransfomer);
        List<Karma> karmas = dataReader.read(karmaPath, karmaTransfomer);
        List<Outcome> outcomes = outcomeGenerator.generate(profiles, karmas);
        outcomeWriter.write(outputPath, outcomes);
    }
}
