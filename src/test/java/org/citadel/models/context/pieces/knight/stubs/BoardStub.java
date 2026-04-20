package org.citadel.models.context.pieces.knight.stubs;

import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.SelectedPiece;

public class BoardStub implements BoardObserver {

    public BoardStub() {
    }

    @Override
    public boolean isOccupied(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean isPieceSamePlayerAt(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean isRival(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean isSquareAttackedBy(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean isKingInCheck() {
        return false;
    }

    @Override
    public boolean isRookAvailableForCastling(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean isVulnerablePawnAt(Coordinate coord) {
        return false;
    }

    @Override
    public void add(SelectedPiece selectedPiece) {
    }

    @Override
    public void remove(SelectedPiece selectedPiece) {
    }
}
