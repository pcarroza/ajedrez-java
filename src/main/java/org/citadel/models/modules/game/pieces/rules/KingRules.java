package org.citadel.models.modules.game.pieces.rules;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KingRules extends MovementRuler {

    private static KingRules instance;

    private KingRules() {
    }

    public static KingRules getInstance() {
        if (instance == null) {
            instance = new KingRules();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Piece piece) {
        final int simpleStep = 1;

        return Stream.of(
                piece.getDisplacedBy(new Coordinate(simpleStep, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(simpleStep, 0)),
                piece.getDisplacedBy(new Coordinate(simpleStep, simpleStep)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, 0)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, simpleStep)),
                piece.getDisplacedBy(new Coordinate(0, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(0, simpleStep)))
                .filter(it -> ValidatorLimitsBoard.getInstance().isWithinLimits(it))
                .filter(it -> !piece.isPieceSamePlayerAt(it))
                .collect(Collectors.toList());
    }
}