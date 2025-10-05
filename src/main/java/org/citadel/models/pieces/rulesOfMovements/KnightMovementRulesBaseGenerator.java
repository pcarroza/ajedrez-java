package org.citadel.models.pieces.rulesOfMovements;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KnightMovementRulesBaseGenerator extends MovementRulesBaseGenerator {

    public KnightMovementRulesBaseGenerator(Piece piece) {
        super(piece);
    }

    @Override
    public void generate() {
        final int doubleStep = 2;
        final int simpleStep = 1;

        possibleMoves = Stream.of(
                piece.getDisplacedBy(new Coordinate(doubleStep, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(doubleStep, simpleStep)),
                piece.getDisplacedBy(new Coordinate(simpleStep, doubleStep)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, doubleStep)),
                piece.getDisplacedBy(new Coordinate(-doubleStep, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, -doubleStep)),
                piece.getDisplacedBy(new Coordinate(simpleStep, -doubleStep)),
                piece.getDisplacedBy(new Coordinate(simpleStep, doubleStep)))
                .filter(it -> ValidatorLimitsBoard.getInstance().isWithinLimits(it))
                .filter(it -> !piece.isOwnPieceAt(it))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
