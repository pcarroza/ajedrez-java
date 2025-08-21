package org.citadel.models;

import org.citadel.models.pieces.Player;

public class Turn {

    private int value = 0;

    public Player getCurrentPlayer() {
        return Player.values()[value];
    }

    public Player getRivalPlayer() {
        Turn clone = this.copy();
        clone.change();
        return clone.getCurrentPlayer();
    }

    public void change() {
        this.value = (value + 1) % (Player.values().length - 1);
    }

    public int getIndexCurrentPlayer() {
        return getCurrentPlayer().ordinal();
    }

    public Turn copy() {
        Turn turn = new Turn();
        turn.value = value;
        return turn;
    }
}
