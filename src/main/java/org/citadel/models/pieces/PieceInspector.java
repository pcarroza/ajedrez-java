package org.citadel.models.pieces;

public final class PieceInspector {

    private PieceInspector() {}

    public static boolean isKing(Piece piece) {
        if (piece == null) return false;
        KingFinderVisitor visitor = new KingFinderVisitor();
        piece.accept(visitor);
        return visitor.isKing();
    }

    public static boolean isRook(Piece piece) {
        if (piece == null) return false;
        RookFinderVisitor visitor = new RookFinderVisitor();
        piece.accept(visitor);
        return visitor.isRook();
    }
}
