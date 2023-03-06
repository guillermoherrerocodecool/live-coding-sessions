package com.codecool.karmatm.logic.outcome;

import com.codecool.karmatm.data.Outcome;
import com.codecool.karmatm.io.FileWriter;
import com.codecool.karmatm.logic.outcome.OutcomeWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.mockito.Mockito.matches;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OutcomeWriterTest {
    @Mock
    FileWriter fileWriter;
    @InjectMocks
    OutcomeWriter outcomeWriter;
    @Captor
    ArgumentCaptor<List<String>> linesCaptor;


    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(List.of(), List.of()),
                of(List.of("name;action;0;category"),
                        List.of(new Outcome("name", Set.of("action"), 0, Set.of("category")))),
                of(List.of("name;action1,action2;0;category"),
                        List.of(new Outcome("name", Set.of("action1", "action2"), 0, Set.of("category")))),
                of(List.of("name;action;0;category1,category2"),
                        List.of(new Outcome("name", Set.of("action"), 0, Set.of("category1", "category2")))),
                of(List.of("name;action1,action2;0;category1,category2"),
                        List.of(new Outcome("name", Set.of("action1", "action2"), 0, Set.of("category1", "category2"))))

                );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void write(List<String> expected, List<Outcome> outcomes) {
        String path = "path";
        outcomeWriter.write(path, outcomes);

        verify(fileWriter).write(matches(path), linesCaptor.capture());
        List<String> lines = linesCaptor.getValue();
        assertEquals(expected.size(), lines.size());
        for (int index = 0; index < lines.size(); index++) {
            String[] expectedLine = expected.get(index).split(";");
            String[] line = lines.get(index).split(";");
            assertEquals(expectedLine[0], line[0]);
            Set<String> expectedActions = Set.of(expectedLine[1].split(","));
            Set<String> actions = Set.of(line[1].split(","));
            assertEquals(expectedActions, actions);
            assertEquals(expectedLine[2], line[2]);
            Set<String> expectedCategories = Set.of(expectedLine[3].split(","));
            Set<String> categories = Set.of(line[3].split(","));
            assertEquals(expectedCategories, categories);
        }
    }
}