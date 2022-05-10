package com.github.mohamead;

import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

final class PointSystem {

    final private static HashMap<Card, Integer> points = new HashMap<>();

    static {
        generatePoints(Suite.CLUB);
        generatePoints(Suite.DIAMOND);
        generatePoints(Suite.HART);
        generatePoints(Suite.SPADE);
    }

    private static void generatePoints(@NotNull Suite suite) {
        for (int i = 2; i < 12; i++) {
            if (i == 11) {
                points.put(new Card(suite, Face.ACE), i);
                continue;
            }
            if (i == 10) {
                points.put(new Card(suite, Face.TEN), i);
                points.put(new Card(suite, Face.JACK), i);
                points.put(new Card(suite, Face.QUEEN), i);
                points.put(new Card(suite, Face.KING), i);
                continue;
            }
            points.put(new Card(suite, Face.of(i + "")), i);
        }
    }

    static HashMap<Card, Integer> getPoints() {
        return points;
    }

    static int getPoint(@NotNull Card card) {
        if (!points.containsKey(card)) {
            throw new IllegalArgumentException("Invalid card \"" + card + "\" found, please try again!");
        }
        return points.get(card);
    }

}
