package com.github.mohamead;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void GivenEmptyListOfCards_WhenCallingDeckGetCards_ThenReturnNewListOfFiftyTwoUniqueCards() {
        final Deck deck = new Deck(new ArrayList<>());
        assertEquals(52, deck.getCards().stream().distinct().count());
    }

    @Test
    void GivenDuplicateCards_WhenCreatingDeck_ThenRuntimeExceptionShouldBeThrown() {
        final List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suite.CLUB, Face.ACE));
        cards.add(new Card(Suite.CLUB, Face.ACE));
        cards.add(new Card(Suite.CLUB, Face.ACE));
        cards.add(new Card(Suite.CLUB, Face.ACE));
        assertThrows(RuntimeException.class, () -> {
            new Deck(cards);
        });
    }

}
