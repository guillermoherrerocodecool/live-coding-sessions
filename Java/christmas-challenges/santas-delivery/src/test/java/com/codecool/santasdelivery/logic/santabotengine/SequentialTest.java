package com.codecool.santasdelivery.logic.santabotengine;

import com.codecool.santasdelivery.data.Chart;
import com.codecool.santasdelivery.data.Position;
import com.codecool.santasdelivery.data.SantaBot;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class SequentialTest {
    SantaBotEngine engine = new Sequential();
    Chart chart = new Chart(
            new String[][]{
                    new String[]{"", ""},
                    new String[]{"", ""}}
    );

    public static Stream<Arguments> parameters() {
        return Stream.of(
                of(new Position(0, 1), new Position(0, 0)),
                of(new Position(1, 0), new Position(0, 1)),
                of(new Position(1, 1), new Position(1, 0)),
                of(new Position(0, 0), new Position(1, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void move(Position expected, Position current) {
        SantaBot santaBot = new SantaBot(current);

        engine.move(santaBot, chart);
        Position result = santaBot.getPosition();

        assertEquals(expected, result);
    }
}