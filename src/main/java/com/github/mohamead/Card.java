package com.github.mohamead;

import org.jetbrains.annotations.NotNull;

class Card {

    private final Suite suite;
    private final Face face;

    Card(@NotNull Suite suite, @NotNull Face face) {
        this.suite = suite;
        this.face = face;
    }

    public Suite getSuite() {
        return suite;
    }

    public Face getFace() {
        return face;
    }

    @Override
    public String toString() {
        return suite.getValue() + face.getValue();
    }

    @Override
    public int hashCode() {
        return suite.hashCode() + face.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card))
            return false;
        return this.hashCode() == obj.hashCode();
    }
}
