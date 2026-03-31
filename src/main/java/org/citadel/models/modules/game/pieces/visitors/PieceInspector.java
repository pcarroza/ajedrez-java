package org.citadel.models.modules.game.pieces.visitors;

import java.util.List;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

public final class PieceInspector {

    private PieceInspector() {
    }

    public static boolean isKing(Piece piece) {
        assert piece != null;
        KingFinderVisitor visitor = new KingFinderVisitor();
        piece.accept(visitor);
        return visitor.isKing();
    }

    public static boolean isPawn(Piece piece) {
        assert piece != null;
        PawnFinderVisitor visitor = new PawnFinderVisitor();
        piece.accept(visitor);
        return visitor.isPawn();
    }

    public static List<Coordinate> getEnPassantDiagonals(Piece piece) {
        assert piece != null;
        EnPassantTargetVisitor visitor = new EnPassantTargetVisitor();
        piece.accept(visitor);
        return visitor.getDiagonals();
    }

    public static boolean isRook(Piece piece) {
        assert piece != null;
        RookFinderVisitor visitor = new RookFinderVisitor();
        piece.accept(visitor);
        return visitor.isRook();
    }

    public static boolean isRookAvailableForCastling(Piece piece) {
        assert piece != null;
        RookCastlingVisitor visitor = new RookCastlingVisitor();
        piece.accept(visitor);
        return visitor.isAvailable();
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

    public static String getPieceSymbol(Piece piece) {
        assert piece != null;
        PieceCharVisitor visitor = new PieceCharVisitor();
        piece.accept(visitor);
        return visitor.getPieceChar();
    }
}
