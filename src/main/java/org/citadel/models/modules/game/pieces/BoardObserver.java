package org.citadel.models.modules.game.pieces;

import java.util.List;

import org.citadel.models.modules.game.pieces.enums.Player;

public interface BoardObserver {

    void add(Piece piece);

    void set(List<Coordinate> coordinates);

    void remove(Piece piece);

    boolean isRival(Coordinate coordinate);

    boolean isRookAvailableForCastling(Coordinate coordinate);

    boolean isVulnerablePawnAt(Coordinate coordinate);

    boolean isOccupied(Coordinate coordinate);

    boolean isPieceSamePlayerAt(Coordinate coordinate);

    boolean isKingInCheck(Player kingPlayer);

    boolean isSquareAttackedBy(Coordinate coordinate, Player attackingPlayer);

}
