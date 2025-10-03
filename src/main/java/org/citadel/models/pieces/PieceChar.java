package org.citadel.models.pieces;

public enum PieceChar {
    PAWN("P"),
    ROOK("T"),
    KNIGHT("C"),
    BISHOP("B"),
    QUEEN("Q"),
    KING("K");

    private final String value;

    PieceChar(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

