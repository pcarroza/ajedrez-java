package org.citadel.models.pieces;

public abstract class SubjectPiece {

    protected BoardObserver boardObserver;

    public void subscribe(BoardObserver boardObserver) {
        this.boardObserver = boardObserver;
    }

    public boolean isEnemy(Coordinate coordinate) {
        return boardObserver.isEnemy(coordinate);
    }

    public boolean isOwnPieceAt(Coordinate coordinate) {
        return boardObserver.isOwnPieceAt(coordinate);
    }

    public boolean isSquareOccupied(Coordinate coordinate) {
        return boardObserver.isSquareOccupied(coordinate);
    }

    public void notifyEnPassantPawn(Piece piece) {
        boardObserver.add(piece);
    }

    public void notifyDeleteEnPassantPawn(Piece piece) {
        boardObserver.deletedEnPassantPawn(piece);
    }
}
