package com.github.mohamead;

import java.util.List;
import org.jetbrains.annotations.NotNull;

class Game {

    private final List<Card> cards;
    private final Player dealer;
    private final Player opponent;
    private Player winner;

    Game(@NotNull Deck deck) {
        this.cards = deck.getCards();
        dealer = new Player("dealer");
        opponent = new Player("sam");
    }

    void play() {
        firstRound();
        boolean opponentsTurn = true;
        while (winner == null) {
            if (opponentsTurn) {
                if (opponent.getScore() >= 17) {
                    if (opponent.getScore() == 21) {
                        setWinner(opponent);
                    }
                    if (opponent.getScore() > 21) {
                        setWinner(dealer);
                    }
                    opponentsTurn = false;
                } else {
                    dealCard(opponent);
                }
            } else {
                if (dealer.getScore() <= opponent.getScore()) {
                    dealCard(dealer);
                    if (dealer.getScore() > 21) {
                        setWinner(opponent);
                    }
                } else {
                    setWinner(dealer);
                }
            }
        }
    }

    private void dealCardsInFirstRound() {
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                dealCard(opponent);
            } else {
                dealCard(dealer);
            }
        }
    }

    private void dealCard(@NotNull Player player) {
        if (cards.size() == 0) {
            throw new IllegalArgumentException("No winner found for given card(s), please try again!");
        }
        player.addCard(cards.get(0));
        cards.remove(0);
    }

    private void firstRound() {
        dealCardsInFirstRound();
        checkWinInFirstRound();
    }

    private void checkWinInFirstRound() {
        final int totalScore = opponent.getScore() + dealer.getScore();
        if (totalScore == 42 || (opponent.getScore() == 21 && dealer.getScore() != 21)) {
            setWinner(opponent);
        }
        if (totalScore == 44 || (dealer.getScore() == 21 && opponent.getScore() != 21)) {
            setWinner(dealer);
        }
    }

    private void setWinner(Player player) {
        this.winner = player;
    }

    void showHands() {
        if (winner == null) {
            throw new RuntimeException("Game has not started, please call play() first!");
        }
        System.out.println(winner.getName());
        opponent.showHand();
        dealer.showHand();
    }

    Player getWinner() {
        if (winner == null) {
            throw new RuntimeException("Game has not started, please call play() first!");
        }
        return winner;
    }

}
