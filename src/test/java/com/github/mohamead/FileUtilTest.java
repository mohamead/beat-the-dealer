package com.github.mohamead;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;

class FileUtilTest {

    @Test
    void GivenValidFile_WhenCallingGetCardsFromFile_ThenReturnListOfCards() {
        final File file = new File(Objects.requireNonNull(this.getClass().getResource("/validCards.csv")).getFile());
        final List<Card> cards = FileUtil.getCardsFromFile(file);
        assertAll("Should contain the following cards: CA, D5, H9, HQ, S8",
                () -> assertTrue(cards.contains(new Card(Suite.CLUB, Face.ACE))),
                () -> assertTrue(cards.contains(new Card(Suite.DIAMOND, Face.FIVE))),
                () -> assertTrue(cards.contains(new Card(Suite.HART, Face.NINE))),
                () -> assertTrue(cards.contains(new Card(Suite.HART, Face.QUEEN))),
                () -> assertTrue(cards.contains(new Card(Suite.SPADE, Face.EIGHT))));
    }

    @Test
    void GivenInvalidFile_WhenCallingGetCardsFromFile_ThenIllegalArgumentExceptionShouldBeThrown() {
        final File file = new File(Objects.requireNonNull(this.getClass().getResource("/invalidCards.csv")).getFile());
        assertThrows(IllegalArgumentException.class, () -> FileUtil.getCardsFromFile(file));
    }

    @Test
    void GivenNull_WhenCallingGetCardsFromFile_ThenReturnEmptyArrayList() {
        assertEquals(new ArrayList<Card>(), FileUtil.getCardsFromFile(null));
    }

    @Test
    void GivenEmptyFile_WhenCallingGetCardsFromFile_ThenIllegalArgumentExceptionShouldBeThrown() {
        final File file = new File(Objects.requireNonNull(this.getClass().getResource("/emptyCards.csv")).getFile());
        assertThrows(IllegalArgumentException.class, () -> FileUtil.getCardsFromFile(file));
    }
}
