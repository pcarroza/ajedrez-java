package org.citadel.views.console;

public enum PieceView {
    PAWN("P"),
    ROOK("T"),
    KNIGHT("C"),
    BISHOP("B"),
    QUEEN("Q"),
    KING("K");

    private final String value;

    PieceView(String value) {
        this.value = value;
    }
}

