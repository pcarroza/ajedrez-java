package org.citadel.models.modules.game.pieces.enums;

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

    public Player getOpponent() {
        if (this == WHITE) {
            return BLACK;
        } else if (this == BLACK) {
            return WHITE;
        }
        return NONE;
    }
}
