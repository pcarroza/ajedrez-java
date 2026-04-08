package org.citadel.models.modules.game.pieces.enums;

import java.util.List;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;

public enum CastlingSide {
    SHORT(8, 7, List.of(5, 6, 7)),
    LONG(1, 2, List.of(2, 3));

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
}