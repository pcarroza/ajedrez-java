package org.citadel.models.pieces;

public interface SelectedPiece {

    void put(Coordinate coordinate);

    boolean isMovementValid(Coordinate coordinate);

    boolean isThePawnPromoted();

    void buildMovements();
}
