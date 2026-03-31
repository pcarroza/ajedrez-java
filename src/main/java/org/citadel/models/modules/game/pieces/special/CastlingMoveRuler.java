package org.citadel.models.modules.game.pieces.special;

import java.util.ArrayList;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;

public class CastlingMoveRuler extends SpecialMovesRuler {

    public CastlingMoveRuler(King king) {
        super(king);
    }

    @Override
    public void generateMovements() {
        movements = new ArrayList<>();
        King king = (King) piece;

        if (king.isMoved()) {
            return;
        }

        int row = king.getCoordinate().row();

        // Enroque Corto (hacia columna 8)
        if (piece.isRookAvailableForCastling(new Coordinate(row, 8))
                && !piece.isSquareOccupied(new Coordinate(row, 5))
                && !piece.isSquareOccupied(new Coordinate(row, 6))
                && !piece.isSquareOccupied(new Coordinate(row, 7))) {
            movements.add(new Coordinate(row, 7));
        }

        // Enroque Largo (hacia columna 1)
        if (piece.isRookAvailableForCastling(new Coordinate(row, 1))
                && !piece.isSquareOccupied(new Coordinate(row, 2))
                && !piece.isSquareOccupied(new Coordinate(row, 3))) {
            movements.add(new Coordinate(row, 2));
        }
    }
}
