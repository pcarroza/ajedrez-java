package org.citadel.models.modules.game.pieces.enums;

import java.util.ArrayList;
import java.util.List;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;

public enum CastlingSide {
    SHORT(8, 7, List.of(6, 7)), // Squares F and G
    LONG(1, 3, List.of(2, 3, 4)); // Squares B, C, and D

    public final int rookColumn;

    public final int kingTargetColumn;

    public final List<Integer> squaresToClear;

    CastlingSide(int rookColumn, int kingTargetColumn, List<Integer> squaresToClear) {
        this.rookColumn = rookColumn;
        this.kingTargetColumn = kingTargetColumn;
        this.squaresToClear = squaresToClear;
    }

    public boolean areSquaresClear(int row, King king) {
        return squaresToClear.stream().noneMatch(column -> king.isOccupied(new Coordinate(row, column)));
    }

    public List<Coordinate> getSquaresKingPassesThrough(Coordinate kingCurrentCoordinate) {
        List<Coordinate> squares = new ArrayList<>();
        int row = kingCurrentCoordinate.row();
        if (this == SHORT) { // Short Castling (King moves from E to G)
            squares.add(new Coordinate(row, kingCurrentCoordinate.column() + 1)); // F file
        } else { // Long Castling (King moves from E to C)
            squares.add(new Coordinate(row, kingCurrentCoordinate.column() - 1)); // D file
        }
        return squares;
    }
}