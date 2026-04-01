package org.citadel.models.modules.game.pieces.rules;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KnightRulerGenerator extends MovementRuleGenerator {

    private static KnightRulerGenerator instance;

    private KnightRulerGenerator() {
    }

    public static KnightRulerGenerator getInstance() {
        if (instance == null) {
            instance = new KnightRulerGenerator();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Piece piece) {
        final int doubleStep = 2;
        final int simpleStep = 1;

        return Stream.of(
                piece.getDisplacedBy(new Coordinate(doubleStep, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(doubleStep, simpleStep)),
                piece.getDisplacedBy(new Coordinate(simpleStep, doubleStep)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, doubleStep)),
                piece.getDisplacedBy(new Coordinate(-doubleStep, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, -doubleStep)),
                piece.getDisplacedBy(new Coordinate(simpleStep, -doubleStep)),
                piece.getDisplacedBy(new Coordinate(simpleStep, doubleStep)))
                .filter(it -> ValidatorLimitsBoard.getInstance().isWithinLimits(it))
                .filter(it -> !piece.isPieceSamePlayerAt(it))
                .collect(Collectors.toList());
    }
}