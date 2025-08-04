package org.citadel.models.pieces.rulesofmovements;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class KnightMovementRuleBuilder extends MovementRuleBuilder {

    public KnightMovementRuleBuilder(Piece piece) {
        super(piece);
    }

    @Override
    public void buildMovements() {
        final int doubleStep = 2;
        final int simpleStep = 1;
        
        possibleMoves = new ArrayList<>(List.of(
                piece.getDisplacedBy(new Coordinate(doubleStep, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(doubleStep, simpleStep)),
                piece.getDisplacedBy(new Coordinate(simpleStep, doubleStep)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, doubleStep)),
                piece.getDisplacedBy(new Coordinate(-doubleStep, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, -doubleStep)),
                piece.getDisplacedBy(new Coordinate(simpleStep, -doubleStep)),
                piece.getDisplacedBy(new Coordinate(simpleStep, doubleStep))));

        possibleMoves.removeIf(it -> !ValidatorLimitsBoard.getInstance().isWithinLimits(it));
        possibleMoves.removeIf(it -> piece.sameColor(it));
    }
}