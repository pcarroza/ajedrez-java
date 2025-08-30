package org.citadel.models.pieces;

import java.util.List;

public interface BoardObserver {

    void add(Piece piece);

    void set(List<Coordinate> coordinates);

    boolean isEnemy(Coordinate coordinate);

    boolean isSquareEmpty(Coordinate coordinate);

    boolean someColor(Coordinate coordinate);

    void deletedEnPassantPawn(Piece piece);
}
