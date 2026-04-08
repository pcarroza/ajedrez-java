package org.citadel.models.modules.game.pieces;

public abstract class SubjectPiece {

    protected BoardObserver boardObserver;

    public void subscribe(BoardObserver boardObserver) {
        this.boardObserver = boardObserver;
    }

    public boolean isRival(Coordinate coordinate) {
        return boardObserver.isRival(coordinate);
    }

    public boolean isPieceSamePlayerAt(Coordinate coordinate) {
        return boardObserver.isPieceSamePlayerAt(coordinate);
    }

    public boolean isRookAvailableForCastling(Coordinate coordinate) {
        return boardObserver.isRookAvailableForCastling(coordinate);
    }

    public boolean isOccupied(Coordinate coordinate) {
        return boardObserver.isOccupied(coordinate);
    }

    public boolean isVulnerablePawnAt(Coordinate coordinate) {
        return boardObserver.isVulnerablePawnAt(coordinate);
    }

    public void notifyEnPassantPawn(Piece piece) {
        boardObserver.add(piece);
    }

    public void notifyDeleteEnPassantPawn(Piece piece) {
        boardObserver.remove(piece);
    }
}
