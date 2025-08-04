package org.citadel.models.pieces;

public abstract class SubjectPiece {

    protected BoardObserver boardObserver;

    public void subscribe(BoardObserver boardObserver) {
        this.boardObserver = boardObserver;
    }

    public boolean isItEnemy(Coordinate coordinate) {
        return boardObserver.isItEnemy(coordinate);
    }

    public boolean sameColor(Coordinate coordinate) {
        return boardObserver.someColor(coordinate);
    }

    public boolean isBoxOccupied(Coordinate coordinate) {
        return !boardObserver.isBoxEmpty(coordinate);
    }

    public void addPassantPawn(Piece piece) {
        boardObserver.set(piece);
    }
}
