package com.github.mohamead;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


class GameTest {

    @Test
    void GivenSamAndDealerHasTwentyOne_WhenPlayingBlackJack_ThenSamIsTheWinner() {
        final List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suite.SPADE, Face.ACE));
        cards.add(new Card(Suite.HART, Face.ACE));
        cards.add(new Card(Suite.SPADE, Face.TEN));
        cards.add(new Card(Suite.HART, Face.TEN));
        final Deck deck = new Deck(cards);
        final Game blackJack = new Game(deck);
        blackJack.play();
        assertEquals("sam", blackJack.getWinner().getName());
    }

    @Test
    void GivenSamAndDealerHasTwentyTwo_WhenPlayingBlackJack_ThenDealerIsTheWinner() {
        final List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suite.SPADE, Face.ACE));
        cards.add(new Card(Suite.HART, Face.ACE));
        cards.add(new Card(Suite.DIAMOND, Face.ACE));
        cards.add(new Card(Suite.CLUB, Face.ACE));
        final Deck deck = new Deck(cards);
        final Game blackJack = new Game(deck);
        blackJack.play();
        assertEquals("dealer", blackJack.getWinner().getName());
    }

    @Test
    void GivenSamHasSeventeenAndDealerHasTwentyOne_WhenPlayingBlackJack_ThenDealerIsTheWinner() {
        final List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suite.CLUB, Face.TEN));
        cards.add(new Card(Suite.CLUB, Face.ACE));
        cards.add(new Card(Suite.CLUB, Face.SEVEN));
        cards.add(new Card(Suite.CLUB, Face.JACK));
        cards.add(new Card(Suite.CLUB, Face.NINE));
        final Deck deck = new Deck(cards);
        final Game blackJack = new Game(deck);
        blackJack.play();
        assertEquals("dealer", blackJack.getWinner().getName());
    }

    @Test
    void GivenSamHasSeventeenAndDealerHasSeventeen_WhenPlayingBlackJack_ThenRuntimeExceptionShouldBeThrown() {
        final List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suite.CLUB, Face.TEN));
        cards.add(new Card(Suite.SPADE, Face.TEN));
        cards.add(new Card(Suite.CLUB, Face.SEVEN));
        cards.add(new Card(Suite.SPADE, Face.SEVEN));
        final Deck deck = new Deck(cards);
        assertThrows(RuntimeException.class, () -> {
            new Game(deck).play();
        });
    }

    @Test
    void GivenSamsScoreIsOverDealer_WhenPlayingBlackJack_ThenRunTimeExceptionShouldBeThrown() {
        final List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suite.CLUB, Face.TEN));
        cards.add(new Card(Suite.SPADE, Face.TEN));
        cards.add(new Card(Suite.CLUB, Face.EIGHT));
        cards.add(new Card(Suite.SPADE, Face.SEVEN));
        final Deck deck = new Deck(cards);
        assertThrows(RuntimeException.class, () -> {
            new Game(deck).play();
        });
    }

    @Test
    void GivenGameIsNotStarted_WhenCallingGetWinner_ThenRuntimeExceptionShouldBeThrown() {
        final List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suite.CLUB, Face.TEN));
        cards.add(new Card(Suite.CLUB, Face.ACE));
        cards.add(new Card(Suite.CLUB, Face.SEVEN));
        cards.add(new Card(Suite.CLUB, Face.JACK));
        cards.add(new Card(Suite.CLUB, Face.NINE));
        final Deck deck = new Deck(cards);
        final Game blackJack = new Game(deck);
        assertThrows(RuntimeException.class, blackJack::getWinner);
    }

    @Test
    void GivenGameIsNotStarted_WhenCallingShowHands_ThenRuntimeExceptionShouldBeThrown() {
        final List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suite.CLUB, Face.TEN));
        cards.add(new Card(Suite.CLUB, Face.ACE));
        cards.add(new Card(Suite.CLUB, Face.SEVEN));
        cards.add(new Card(Suite.CLUB, Face.JACK));
        cards.add(new Card(Suite.CLUB, Face.NINE));
        final Deck deck = new Deck(cards);
        final Game blackJack = new Game(deck);
        assertThrows(RuntimeException.class, blackJack::getWinner);
    }
}
