package com.github.mohamead;

enum Face {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private final String value;

    Face(String value) {
        this.value = value;
    }

    static Face of(String value) {
        for (Face face : values()) {
            if (face.getValue().equals(value)) {
                return face;
            }
        }
        throw new IllegalArgumentException("Invalid Face value found \"" + value + "\", please try again!");
    }

    static String getRegex() {
        return "(" + TWO.value + "|" + THREE.value + "|" + FOUR.value + "|" + FIVE.value + "|" + SIX.value + "|" + SEVEN.value + "|" + EIGHT.value + "|"
                + NINE.value + "|" + TEN.value + "|" + JACK.value + "|" + QUEEN.value + "|" + KING.value + "|" + ACE.value + ")";
    }

    public String getValue() {
        return value;
    }

}
