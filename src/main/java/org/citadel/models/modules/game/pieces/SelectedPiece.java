package org.citadel.models.modules.game.pieces;

import org.citadel.models.modules.game.pieces.visitors.PieceVisitor;

public interface SelectedPiece {

    void put(Coordinate coordinate);

    boolean isMovementValid(Coordinate coordinate);

    void generateMovements();

    void accept(PieceVisitor visitor);

    Coordinate getCoordinate();
}
