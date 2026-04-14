package org.citadel.models.modules.game.pieces;

import org.citadel.models.modules.game.pieces.enums.Player;

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

    public boolean isKingInCheck(Player kingPlayer) {
        return boardObserver.isKingInCheck(kingPlayer);
    }

    public boolean isSquareAttackedBy(Coordinate coordinate, Player attackingPlayer) {
        return boardObserver.isSquareAttackedBy(coordinate, attackingPlayer);
    }

    public void notifyDeleteEnPassantPawn(Piece piece) {
        boardObserver.remove(piece);
    }
}
