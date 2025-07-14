package org.citadel.models.pieces;

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
}
