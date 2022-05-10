package com.github.mohamead;

import org.jetbrains.annotations.NotNull;

enum Suite {
    CLUB("C"),
    DIAMOND("D"),
    HART("H"),
    SPADE("S");

    private final String value;

    Suite(@NotNull String value) {
        this.value = value;
    }

    static Suite of(@NotNull String value) {
        for (Suite suite : values()) {
            if (suite.value.equals(value)) {
                return suite;
            }
        }
        throw new IllegalArgumentException("Invalid Suite value found \"" + value + "\", please try again!");
    }

    public static String getRegex() {
        return "(" + CLUB.value + "|" + DIAMOND.value + "|" + HART.value + "|" + SPADE.value + ")";
    }

    public String getValue() {
        return value;
    }
}
