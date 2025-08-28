package org.citadel.models.pieces;

public final class PieceInspector {

    private PieceInspector() {
    }

    public static boolean isKing(Piece piece) {
        assert piece != null;
        KingFinderVisitor visitor = new KingFinderVisitor();
        piece.accept(visitor);
        return visitor.isKing();
    }

    public static boolean isRook(Piece piece) {
        assert piece != null;
        RookFinderVisitor visitor = new RookFinderVisitor();
        piece.accept(visitor);
        return visitor.isRook();
    }

    public static boolean isPawnPromoted(Piece piece) {
        assert piece != null;
        PawnPromotionVisitor visitor = new PawnPromotionVisitor();
        piece.accept(visitor);
        return visitor.isPromoted();
    }
}
