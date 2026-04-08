package org.citadel.models.modules.game.pieces.visitors;

import java.util.List;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

public final class PieceInspector {

    private PieceInspector() {
    }

    public static List<Coordinate> getSpecialMovements(Piece piece) {
        assert piece != null;
        SpecialMovesVisitor visitor = new SpecialMovesVisitor();
        piece.accept(visitor);
        return visitor.getMovements();
    }
}
