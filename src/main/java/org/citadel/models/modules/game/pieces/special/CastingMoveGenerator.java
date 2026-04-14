package org.citadel.models.modules.game.pieces.special;

import java.util.Arrays;
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
        if (king.isMoved())
            return List.of();

        return Arrays.stream(CastlingSide.values())
                .filter(side -> king.isStructurallyValid(side))
                .filter(side -> king.isDynamicallyValid(side))
                .map(king::getCastingCoordinate)
                .toList();
    }
}
