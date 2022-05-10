package com.github.mohamead;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class Player {

    private final String name;
    private final List<Card> cards;
    private int score;

    Player(@NotNull String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    void addCard(@NotNull Card card) {
        cards.add(card);
        score = calculateScore();
    }

    int calculateScore() {
        int sum = 0;
        for (Card card : cards) {
            sum += PointSystem.getPoint(card);
        }
        return sum;
    }

    void showHand() {
        System.out.println(this.name + ": " + cards.toString().replace("[", "").replace("]", ""));
    }

    String getName() {
        return name;
    }

    int getScore() {
        return score;
    }

}
