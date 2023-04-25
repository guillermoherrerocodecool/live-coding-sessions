package com.codecool.santasdelivery.logic.track;

import com.codecool.santasdelivery.data.Track;
import com.codecool.santasdelivery.io.FileWriter;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class TrackWriter {
    private final FileWriter fileWriter;

    public TrackWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void write(Track track, String output_path) {
        List<String> lines = parseToLines(track);
        fileWriter.write(lines, output_path);
    }

    private List<String> parseToLines(Track track) {
        return track.positions().stream()
                .map(position -> format("(%d, %d)", position.y(), position.x()))
                .collect(toList());

    }
}
