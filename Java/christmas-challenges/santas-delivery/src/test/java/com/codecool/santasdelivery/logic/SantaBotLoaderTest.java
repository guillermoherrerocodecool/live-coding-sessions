package com.codecool.santasdelivery.logic;

import com.codecool.santasdelivery.data.Chart;
import com.codecool.santasdelivery.data.Position;
import com.codecool.santasdelivery.data.SantaBot;
import com.codecool.santasdelivery.logic.santabot.SantaBotLoader;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class SantaBotLoaderTest {
    static String headquarters = "test";
    SantaBotLoader santaBotLoader = new SantaBotLoader(headquarters);

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(new Position(0, 0), new String[][]{new String[]{headquarters}}),
                of(new Position(0, 0), new String[][]{new String[]{headquarters, ""}, new String[]{"", ""}}),
                of(new Position(0, 1), new String[][]{new String[]{"", headquarters}, new String[]{"", ""}}),
                of(new Position(1, 0), new String[][]{new String[]{"", ""}, new String[]{headquarters, ""}}),
                of(new Position(1, 1), new String[][]{new String[]{"", ""}, new String[]{"", headquarters}}),
                of(new Position(1, 1), new String[][]{new String[]{"", "", ""},
                        new String[]{"", headquarters, ""}, new String[]{"", "", ""}})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void load(Position expected, String[][] tiles) {
        Chart chart = new Chart(tiles);

        SantaBot santaBot = santaBotLoader.load(chart);
        Position result = santaBot.getPosition();

        assertEquals(expected, result);
    }
}