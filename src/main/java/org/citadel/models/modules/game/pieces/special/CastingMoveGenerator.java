package org.citadel.models.modules.game.pieces.special;

import java.util.ArrayList;
import java.util.List;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.enums.CastlingSide;

public class CastingMoveGenerator extends SpecialMoveGenerator<King> {

    private static CastingMoveGenerator instance;

    private CastingMoveGenerator() {
    }

    public static CastingMoveGenerator getInstance() {
        if (instance == null) {
            instance = new CastingMoveGenerator();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generator(King king) {
        List<Coordinate> movements = new ArrayList<>();
        if (king.isMoved())
            return new ArrayList<>();

        for (CastlingSide side : CastlingSide.values()) {
            if (king.isCastlingAvailable(side)) {
                movements.add(king.getCastingCoordinate(side));
            }
        }
        return movements;
    }
}
