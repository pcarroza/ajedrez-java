package org.citadel.models.pieces;

public abstract class SubjectPiece {

    protected BoardObserver boardObserver;

    public void subscribe(BoardObserver boardObserver) {
        this.boardObserver = boardObserver;
    }

    public boolean isItEnemy(Coordinate coordinate) {
        return boardObserver.isEnemy(coordinate);
    }

    public boolean isPieceCurrentPlayer(Coordinate coordinate) {
        return boardObserver.isPieceCurrentPlayer(coordinate);
    }

    public boolean isSquareEmpty(Coordinate coordinate) {
        return boardObserver.isSquareEmpty(coordinate);
    }

    public void notifyEnPassantPawn(Piece piece) {
        boardObserver.add(piece);
    }

    public void notifyDeleteEnPassantPawn(Piece piece) {
        boardObserver.deletedEnPassantPawn(piece);
    }
}
