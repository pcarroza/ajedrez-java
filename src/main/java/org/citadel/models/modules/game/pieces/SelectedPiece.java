package org.citadel.models.modules.game.pieces;

import java.util.List;

public interface SelectedPiece {

    void put(Coordinate coordinate);

    boolean isMovementValid(Coordinate coordinate);

    void generateMovements();

    Coordinate getCoordinate();

    List<Coordinate> getMovements();

    boolean isKing();

    boolean isPawn();

    boolean isRook();

    boolean isRookAvailableForCastling();

    boolean isPromoted();

    boolean isPawnPromoted();

    List<Coordinate> getEnPassantDiagonals();

    String getSymbol();
}