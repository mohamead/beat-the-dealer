package com.github.mohamead;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.jetbrains.annotations.NotNull;

class Deck {

    private final List<Card> cards;

    Deck(@NotNull List<Card> cards) {
        if (cards.size() != cards.stream().distinct().count()) {
            throw new IllegalArgumentException("Duplicate card(s) found, please try again!");
        }
        this.cards = cards.isEmpty() ? getShuffledCards() : cards;
    }

    private static List<Card> getShuffledCards() {
        final List<Card> shuffledCards = new ArrayList<>(PointSystem.getPoints().keySet());
        Collections.shuffle(shuffledCards, new Random());
        return shuffledCards;
    }

    List<Card> getCards() {
        return cards;
    }
}
