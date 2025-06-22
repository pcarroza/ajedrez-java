package org.citadel.models;

import org.citadel.models.pieces.Color;

public class Turn implements Cloneable {

    private int value = 0;

    public Color getColor() {
        return Color.values()[value];
    }

    public void change() {
        this.value = (value + 1) % (Color.values().length - 1);
    }

    @Override
    public Turn clone() {
        try {
            return (Turn) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
