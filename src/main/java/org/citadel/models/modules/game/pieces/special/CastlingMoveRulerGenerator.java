package org.citadel.models.modules.game.pieces.special;

import java.util.ArrayList;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.enums.CastlingSide;

public class CastlingMoveRulerGenerator extends SpecialRulesGenerator {

    private final King king;

    public CastlingMoveRulerGenerator(King king) {
        this.king = king;
    }

    @Override
    public void generate() {
        movements = new ArrayList<>();

        if (king.isMoved())
            return;

        int row = king.getCoordinate().row();

        for (CastlingSide side : CastlingSide.values()) {
            if (isCastlingAvailable(row, side)) {
                movements.add(new Coordinate(row, side.kingTargetColumn));
            }
        }
    }

    private boolean isCastlingAvailable(int row, CastlingSide side) {
        Coordinate target = new Coordinate(row, side.rookColumn);
        return king.isRookAvailableForCastling(target) && side.areSquaresClear(row, king);
    }
}