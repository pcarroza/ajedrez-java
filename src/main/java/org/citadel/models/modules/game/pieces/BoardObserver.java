package org.citadel.models.modules.game.pieces;

public interface BoardObserver {

    void add(SelectedPiece selectedPiece);

    void remove(SelectedPiece selectedPiece);

    boolean isRival(Coordinate coordinate);

    boolean isRookAvailableForCastling(Coordinate coordinate);

    boolean isVulnerablePawnAt(Coordinate coordinate);

    boolean isOccupied(Coordinate coordinate);

    boolean isPieceSamePlayerAt(Coordinate coordinate);

    boolean isKingInCheck();

    boolean isSquareAttackedBy(Coordinate coordinate);
}
