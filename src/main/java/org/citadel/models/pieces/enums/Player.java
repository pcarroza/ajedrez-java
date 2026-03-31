package org.citadel.models.pieces;

public enum Player {
    BLACK(-1),
    WHITE(1),
    NONE(0);

    private final int player;

    Player(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }
}
