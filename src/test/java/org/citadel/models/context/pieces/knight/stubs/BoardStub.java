package org.citadel.models.context.pieces.knight.stubs;

import java.util.List;

import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;
import org.citadel.models.modules.game.pieces.enums.Player;

public class BoardStub implements BoardObserver {

    public BoardStub() {
    }

    @Override
    public void set(List<Coordinate> selectedPieceMovements) {
    }

    @Override
    public void add(Piece enPassantPawn) {
        assert enPassantPawn != null;
    }

    @Override
    public void remove(Piece enPassantPawn) {
        assert enPassantPawn != null;
    }

    @Override
    public boolean isRival(Coordinate coordinate) {
        assert coordinate != null;
        return false;
    }

    @Override
    public boolean isPieceSamePlayerAt(Coordinate coordinate) {
        assert coordinate != null;
        return false;
    }

    @Override
    public boolean isVulnerablePawnAt(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean isRookAvailableForCastling(Coordinate coordinate) {
        assert coordinate != null;
        return false;
    }

    @Override
    public boolean isOccupied(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean isKingInCheck(Player kingPlayer) {
        return false;
    }

    @Override
    public boolean isSquareAttackedBy(Coordinate coordinate, Player attackingPlayer) {
        return false;
    }
}
