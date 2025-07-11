package org.citadel.models.pieces.rulesofmovements;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class KingMoveRulesManager extends MoveRulesManager {

    public KingMoveRulesManager(Piece piece) {
        super(piece);
    }

    @Override
    public void buildMovements() {
        final int simpleStep = 1;

        possibleMoves = new ArrayList<>(List.of(
                piece.getDisplacedCoordinateBy(new Coordinate(simpleStep, -simpleStep)),
                piece.getDisplacedCoordinateBy(new Coordinate(simpleStep, 0)),
                piece.getDisplacedCoordinateBy(new Coordinate(simpleStep, simpleStep)),
                piece.getDisplacedCoordinateBy(new Coordinate(-simpleStep, 0)),
                piece.getDisplacedCoordinateBy(new Coordinate(-simpleStep, -simpleStep)),
                piece.getDisplacedCoordinateBy(new Coordinate(-simpleStep, simpleStep)),
                piece.getDisplacedCoordinateBy(new Coordinate(0, -simpleStep)),
                piece.getDisplacedCoordinateBy(new Coordinate(0, simpleStep))));

        possibleMoves.removeIf(it -> !ValidatorLimitsBoard.getInstance().isWithinLimits(it));
        possibleMoves.removeIf(it -> piece.sameColor(it));
    }
}
