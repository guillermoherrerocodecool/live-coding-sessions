package com.codecool.karmatm.logic;

import com.codecool.karmatm.data.Karma;
import com.codecool.karmatm.data.Outcome;
import com.codecool.karmatm.data.Profile;
import com.codecool.karmatm.logic.outcome.OutcomeGenerator;
import com.codecool.karmatm.logic.outcome.OutcomeWriter;
import com.codecool.karmatm.logic.reader.DataReader;
import com.codecool.karmatm.logic.reader.KarmaTransformer;
import com.codecool.karmatm.logic.reader.ProfileTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class KarmaTMTest {
    @Mock
    DataReader dataReader;
    @Mock
    ProfileTransformer profileTransformer;
    @Mock
    KarmaTransformer karmaTransformer;
    @Mock
    OutcomeGenerator outcomeGenerator;
    @Mock
    OutcomeWriter outcomeWriter;
    @InjectMocks
    KarmaTM karmaTM;

    //TODO: complete on a later stage (solve Mockito generics issue)
    @Test
    void evaluate() {
//        String profilesPath = "profiles";
//        String karmaPath = "karma";
//        String outputPath = "output";
//        List<Profile> profiles = List.of();
//        List<Karma> karmas = List.of();
//        List<Outcome> outcomes = List.of();
//        when(dataReader.read(profilesPath, profileTransformer)).thenReturn(profiles);
//        when(dataReader.read(karmaPath, karmaTransformer)).thenReturn(karmas);
//        when(outcomeGenerator.generate(profiles, karmas)).thenReturn(outcomes);
//
//        karmaTM.evaluate(profilesPath, karmaPath, outputPath);
//
//        verify(dataReader).read(profilesPath, profileTransformer);
//        verify(dataReader).read(karmaPath, karmaTransformer);
//        verify(outcomeGenerator).generate(profiles, karmas);
//        verify(outcomeWriter).write(outputPath, outcomes);
    }
}