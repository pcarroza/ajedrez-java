package org.citadel.models;

import org.citadel.models.pieces.Color;

public class Turn {

    private int value = 0;

    public Color getColor() {
        return Color.values()[value];
    }

    public void change() {
        this.value = (value + 1) % (Color.values().length - 1);
    }

    public Turn copy() {
        Turn turn = new Turn();
        turn.value = value;
        return turn;
    }
}
