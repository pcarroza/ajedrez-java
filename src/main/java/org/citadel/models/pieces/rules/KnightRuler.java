package org.citadel.models.pieces.rules;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KnightRuler extends MovementRuler {

    private static KnightRuler instance;

    private KnightRuler() {
    }

    public static KnightRuler getInstance() {
        if (instance == null) {
            instance = new KnightRuler();
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
                .filter(it -> !piece.isSameColorPieceAt(it))
                .collect(Collectors.toList());
    }
}