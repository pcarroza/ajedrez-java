package org.citadel.models.modules.game.pieces;

import java.util.List;

public interface BoardObserver {

    void add(Piece piece);

    void set(List<Coordinate> coordinates);

    boolean isRival(Coordinate coordinate);

    boolean isRookAvailableForCastling(Coordinate coordinate);

    boolean isVulnerablePawnAt(Coordinate coordinate);

    boolean isOccupied(Coordinate coordinate);

    boolean isPieceSamePlayerAt(Coordinate coordinate);

    void remove(Piece piece);
}
