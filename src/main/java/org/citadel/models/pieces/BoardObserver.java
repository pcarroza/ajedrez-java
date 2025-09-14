package org.citadel.models.pieces;

import java.util.List;

public interface BoardObserver {

    void add(Piece piece);

    void set(List<Coordinate> coordinates);

    boolean isEnemy(Coordinate coordinate);

    boolean isSquareOccupied(Coordinate coordinate);

    boolean isOwnPieceAt(Coordinate coordinate);

    void remove(Piece piece);
}
