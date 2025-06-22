package org.citadel.models.pieces;

import java.util.List;

public interface ObserverBoard {

    void set(Piece piece);

    void set(List<Coordinate> coordinates);

    boolean isItEnemy(Coordinate coordinate);

    boolean isBoxEmpty(Coordinate coordinate);

    boolean someColor(Coordinate coordinate);
}
