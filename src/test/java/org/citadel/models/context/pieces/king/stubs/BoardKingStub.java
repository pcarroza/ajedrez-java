package org.citadel.models.context.pieces.king.stubs;

import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class BoardKingStub implements BoardObserver {

    private boolean isKingInCheck = false;

    private Map<Coordinate, Boolean> attackedSquares = new HashMap<>();

    private Map<Coordinate, Boolean> occupiedSquares = new HashMap<>();

    private Map<Coordinate, Boolean> rookAvailableForCastling = new HashMap<>();

    private Map<Coordinate, Player> pieceSamePlayerAt = new HashMap<>();

    public BoardKingStub setKingInCheck(boolean value) {
        this.isKingInCheck = value;
        return this;
    }

    public BoardKingStub setSquareAttackedBy(int row, int col, boolean value) {
        this.attackedSquares.put(new Coordinate(row, col), value);
        return this;
    }

    public BoardKingStub setOccupied(int row, int col, boolean value) {
        this.occupiedSquares.put(new Coordinate(row, col), value);
        return this;
    }

    public BoardKingStub setRookAvailableForCastling(int row, int col, boolean value) {
        this.rookAvailableForCastling.put(new Coordinate(row, col), value);
        return this;
    }

    public BoardKingStub setPieceSamePlayerAt(int row, int col, Player player) {
        this.pieceSamePlayerAt.put(new Coordinate(row, col), player);
        return this;
    }

    @Override
    public void add(Piece piece) {
    }

    @Override
    public void set(List<Coordinate> coordinates) {
    }

    @Override
    public boolean isRival(Coordinate coordinate) {
        return false; // Not directly relevant for castling validation in King.java
    }

    @Override
    public boolean isRookAvailableForCastling(Coordinate coordinate) {
        return this.rookAvailableForCastling.getOrDefault(coordinate, false);
    }

    @Override
    public boolean isVulnerablePawnAt(Coordinate coordinate) {
        return false; // Not relevant for castling
    }

    @Override
    public boolean isOccupied(Coordinate coordinate) {
        return this.occupiedSquares.getOrDefault(coordinate, false);
    }

    @Override
    public boolean isPieceSamePlayerAt(Coordinate coordinate) {
        return this.pieceSamePlayerAt.containsKey(coordinate);
    }

    @Override
    public void remove(Piece piece) {
    }

    @Override
    public boolean isKingInCheck() {
        return this.isKingInCheck;
    }

    @Override
    public boolean isSquareAttackedBy(Coordinate coordinate) {
        return this.attackedSquares.getOrDefault(coordinate, false);
    }
}
