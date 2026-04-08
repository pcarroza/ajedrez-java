package org.citadel.models.modules.game.pieces.special;

import java.util.ArrayList;
import java.util.List;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Piece;
import org.citadel.models.modules.game.pieces.enums.CastlingSide;

public class CastlingMoveRulerGenerator extends SpecialRulesGenerator {

    @Override
    public List<Coordinate> generate(Piece piece) {
        King king = (King) piece;
        assert !king.isMoved();

        List<Coordinate> movements = new ArrayList<>();

        for (CastlingSide side : CastlingSide.values()) {
            if (king.isCastlingAvailable(side)) {
                movements.add(king.getCastingCoordinate(side));
            }
        }

        return movements;
    }
}