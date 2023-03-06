package com.codecool.karmatm.logic.outcome;

import com.codecool.karmatm.data.Outcome;
import com.codecool.karmatm.io.FileWriter;

import java.util.List;

public class OutcomeWriter {
    private final FileWriter fileWriter;

    public OutcomeWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void write(String outputPath, List<Outcome> outcomes) {
        List<String> lines = transformToLines(outcomes);
        fileWriter.write(outputPath, lines);
    }

    private List<String> transformToLines(List<Outcome> outcomes) {
        return outcomes.stream()
                .map(this::transformToLine)
                .toList();
    }

    private String transformToLine(Outcome outcome) {
        String template = "%s;%s;%s;%s";
        return template.formatted(
                outcome.name(),
                String.join(",", outcome.actions()),
                outcome.karma(),
                String.join(",", outcome.idealPresentCategories())
        );
    }
}
