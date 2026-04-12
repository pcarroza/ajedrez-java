package org.citadel.models.modules.game.pieces.enums;

public enum PieceSymbol {
    PAWN("P"),
    ROOK("T"),
    KNIGHT("C"),
    BISHOP("B"),
    QUEEN("Q"),
    KING("K"),
    EMPTY(".");

    private final String value;

    PieceSymbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}