package com.github.mohamead;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void givenTwoCards_whenFaceIsNotEqual_ThenEqualsShouldBeFalse() {
        final Card card1 = new Card(Suite.CLUB, Face.JACK);
        final Card card2 = new Card(Suite.CLUB, Face.ACE);
        assertNotEquals(card1, card2);
    }

    @Test
    void givenTwoCards_whenSuiteIsNotEqual_ThenEqualsShouldBeFalse() {
        final Card card1 = new Card(Suite.CLUB, Face.JACK);
        final Card card2 = new Card(Suite.HART, Face.JACK);
        assertNotEquals(card1, card2);
    }

    @Test
    void givenTwoCards_whenSuiteAndFaceIsEqual_ThenEqualsShouldBeTrue() {
        final Card card1 = new Card(Suite.CLUB, Face.JACK);
        final Card card2 = new Card(Suite.CLUB, Face.JACK);
        assertEquals(card1, card2);
    }

}
