package org.citadel.models.modules.game.pieces.enums;

public enum PieceSimbol {
    PAWN("P"),
    ROOK("T"),
    KNIGHT("C"),
    BISHOP("B"),
    QUEEN("Q"),
    KING("K");

    private final String value;

    PieceSimbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}