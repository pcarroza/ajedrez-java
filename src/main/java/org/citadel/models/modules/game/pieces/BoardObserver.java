package org.citadel.models.modules.game.pieces;

import java.util.List;

public interface BoardObserver {

    void add(Piece piece);

    void set(List<Coordinate> coordinates);

    boolean isEnemy(Coordinate coordinate);

    boolean isRookAvailableForCastling(Coordinate coordinate);

    boolean isSquareOccupied(Coordinate coordinate);

    boolean isOwnPieceAt(Coordinate coordinate);

    boolean isVulnerablePawnAt(Coordinate coordinate);

    void remove(Piece piece);
}
