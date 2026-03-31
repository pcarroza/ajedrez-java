package org.citadel.models.pieces.rules;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KingGenerator extends MovementBaseGenerator {

    private static KingGenerator instance;

    private KingGenerator() {
    }

    public static KingGenerator getInstance() {
        if (instance == null) {
            instance = new KingGenerator();
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
                .filter(it -> !piece.isSameColorPieceAt(it))
                .collect(Collectors.toList());
    }
}