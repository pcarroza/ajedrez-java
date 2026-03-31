package org.citadel.models.pieces.visitors;

import org.citadel.models.pieces.Piece;

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

    public static boolean isPawnVulnerable(Piece piece) {
        assert piece != null;
        PawnVulnerabilityVisitor visitor = new PawnVulnerabilityVisitor();
        piece.accept(visitor);
        return visitor.isVulnerable();
    }

    public static String getChar(Piece piece) {
        assert piece != null;
        PieceCharVisitor visitor = new PieceCharVisitor();
        piece.accept(visitor);
        return visitor.getPieceChar();
    }
}
