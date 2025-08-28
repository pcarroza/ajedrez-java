package org.citadel.models.pieces;

public abstract class SubjectPiece {

    protected BoardObserver boardObserver;

    public void subscribe(BoardObserver boardObserver) {
        this.boardObserver = boardObserver;
    }

    public boolean isItEnemy(Coordinate coordinate) {
        return boardObserver.isEnemy(coordinate);
    }

    public boolean sameColor(Coordinate coordinate) {
        return boardObserver.someColor(coordinate);
    }

    public boolean isBoxOccupied(Coordinate coordinate) {
        return !boardObserver.isSquareEmpty(coordinate);
    }

    public void notifyPassingPawn(Piece piece) {
        boardObserver.add(piece);
    }
}
