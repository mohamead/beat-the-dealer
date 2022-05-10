package com.github.mohamead;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class PointSystemTest {

    @Test
    void GivenPointSystem_WhenCallingGetPoints_ThenReturnPoints() {
        final HashMap<Card, Integer> points = PointSystem.getPoints();
        assertAll("Should return 52 cards with a total of 380 points",
                () -> assertEquals(52, points.keySet().size()),
                () -> assertEquals(380, points.values().stream().mapToInt(Integer::intValue).sum()));
    }

    @ParameterizedTest
    @EnumSource(Suite.class)
    void GivenCardIsBetweenTwoAndTen_WhenCallingGetPoint_ThenReturnCorrespondingPoints(Suite suite) {
        for (int i = 2; i < 11; i++) {
            assertEquals(i, PointSystem.getPoint(new Card(suite, Face.of(i + ""))));
        }
    }

    @ParameterizedTest
    @EnumSource(Suite.class)
    void GivenCardIsBetweenJackAndKing_WhenCallingGetPoint_ThenReturnTenPoints(Suite suite) {
        assertAll(
                () -> assertEquals(10, PointSystem.getPoint(new Card(suite, Face.JACK))),
                () -> assertEquals(10, PointSystem.getPoint(new Card(suite, Face.QUEEN))),
                () -> assertEquals(10, PointSystem.getPoint(new Card(suite, Face.KING)))
        );
    }

    @ParameterizedTest
    @EnumSource(Suite.class)
    void GivenCardIsAce_whenCallingGetPoint_ThenReturnElevenPoints(Suite suite) {
        assertEquals(11, PointSystem.getPoint(new Card(suite, Face.ACE)));
    }

}
