package org.citadel.models.context.pieces.king.stubs;

import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;
import org.citadel.models.support.Square;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardKingStub implements BoardObserver {

    private boolean kingInCheck = false;

    private final Map<Coordinate, Boolean> attackedSquares = new HashMap<>();

    private final Map<Coordinate, Boolean> occupiedSquares = new HashMap<>();

    private final Map<Coordinate, Boolean> rookAvailability = new HashMap<>();

    private final Map<Coordinate, Boolean> samePlayerSquares = new HashMap<>();

    public BoardKingStub withKingInCheck(boolean value) {
        this.kingInCheck = value;
        return this;
    }

    public BoardKingStub withSquareAttacked(String square, boolean value) {
        attackedSquares.put(Square.from(square).toCoordinate(), value);
        return this;
    }

    public BoardKingStub withSquareOccupied(String square, boolean value) {
        occupiedSquares.put(Square.from(square).toCoordinate(), value);
        return this;
    }

    public BoardKingStub withRookAvailable(String square, boolean value) {
        rookAvailability.put(Square.from(square).toCoordinate(), value);
        return this;
    }

    public BoardKingStub withSamePlayerAt(String square, boolean value) {
        samePlayerSquares.put(Square.from(square).toCoordinate(), value);
        return this;
    }

    @Override
    public boolean isKingInCheck() {
        return kingInCheck;
    }

    @Override
    public boolean isSquareAttackedBy(Coordinate coordinate) {
        return attackedSquares.getOrDefault(coordinate, false);
    }

    @Override
    public boolean isOccupied(Coordinate coordinate) {
        return occupiedSquares.getOrDefault(coordinate, false);
    }

    @Override
    public boolean isRookAvailableForCastling(Coordinate coordinate) {
        return rookAvailability.getOrDefault(coordinate, false);
    }

    @Override
    public boolean isPieceSamePlayerAt(Coordinate coordinate) {
        return samePlayerSquares.getOrDefault(coordinate, false);
    }

    @Override
    public boolean isRival(Coordinate coordinate) {
        return false;
    }

    @Override
    public boolean isVulnerablePawnAt(Coordinate coord) {
        return false;
    }

    @Override
    public void add(Piece piece) {
    }

    @Override
    public void set(List<Coordinate> coordinates) {
    }

    @Override
    public void remove(Piece piece) {
    }
}