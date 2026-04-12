package org.citadel.models.modules.game.pieces;

import java.util.List;

import org.citadel.models.modules.game.pieces.enums.PieceSymbol;

public interface SelectedPiece {

    void put(Coordinate coordinate);

    void generateMovements();

    PieceSymbol getSymbol();

    Coordinate getCoordinate();

    List<Coordinate> getMovements();

    List<Coordinate> getEnPassantDiagonals();

    boolean isMovementValid(Coordinate coordinate);

    boolean isRookAvailableForCastling();

    boolean isKing();

    boolean isPawn();

    boolean isRook();

    boolean isPromoted();

    boolean isPawnPromoted();
}