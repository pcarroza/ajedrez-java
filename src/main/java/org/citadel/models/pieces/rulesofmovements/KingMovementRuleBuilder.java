package org.citadel.models.pieces.rulesofmovements;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class KingMovementRuleBuilder extends MovementRuleBuilder {

    public KingMovementRuleBuilder(Piece piece) {
        super(piece);
    }

    @Override
    public void buildMovements() {
        final int simpleStep = 1;

        possibleMoves = new ArrayList<>(List.of(
                piece.getDisplacedBy(new Coordinate(simpleStep, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(simpleStep, 0)),
                piece.getDisplacedBy(new Coordinate(simpleStep, simpleStep)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, 0)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, simpleStep)),
                piece.getDisplacedBy(new Coordinate(0, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(0, simpleStep))));

        possibleMoves.removeIf(it -> !ValidatorLimitsBoard.getInstance().isWithinLimits(it));
        possibleMoves.removeIf(it -> piece.sameColor(it));
    }
}
