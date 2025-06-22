package org.citadel.models.pieces;

public interface SelectablePiece {

    void put(Coordinate coordinate);

    boolean isMovementValid(Coordinate coordinate);

    boolean isThePawnPromoted();

    void buildMovements();

    void notifiesMovementsToTheBoard();
}
