package com.github.mohamead;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EnumTest {

    @Test
    void givenWrongFaceValue_whenCallingOf_ThenIllegalArgumentExceptionShouldBeThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            Face.of("asdf");
        });
    }

    @Test
    void givenWrongSuiteValue_whenCallingOf_ThenIllegalArgumentExceptionShouldBeThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            Suite.of("sdfa");
        });
    }

}
