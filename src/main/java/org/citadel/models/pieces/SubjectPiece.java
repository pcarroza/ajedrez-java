package org.citadel.models.pieces;

import java.util.List;

public abstract class SubjectPiece {

    protected ObserverBoard observerBoard;

    public void subscribe(ObserverBoard observerBoard) {
        this.observerBoard = observerBoard;
    }

    public boolean isItEnemy(Coordinate coordinate) {
        return observerBoard.isItEnemy(coordinate);
    }

    public boolean sameColor(Coordinate coordinate) {
        return observerBoard.someColor(coordinate);
    }

    public boolean isBoxOccupied(Coordinate coordinate) {
        return !observerBoard.isBoxEmpty(coordinate);
    }

    public void addPassantPawn(Piece piece) {
        observerBoard.set(piece);
    }

    protected void notify(List<Coordinate> coordinates) {
        observerBoard.set(coordinates);
    }
}
