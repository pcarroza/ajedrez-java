package org.citadel.models.modules.game.pieces;

public interface SelectedPiece {

    void put(Coordinate coordinate);

    boolean isMovementValid(Coordinate coordinate);

    void generateMovements();
}
