package org.citadel.models.pieces.rulesofmovements;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;

public class KingMoveRulesManager extends MoveRulesManager {

    public KingMoveRulesManager(Piece piece) {
        super(piece);
    }

    @Override
    public void buildMovements() {
        final int simpleStep = 1;
        possibleMoves = new ArrayList<>();
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(simpleStep, -simpleStep)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(simpleStep, 0)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(simpleStep, simpleStep)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(-simpleStep, 0)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(-simpleStep, -simpleStep)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(-simpleStep, simpleStep)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(0, -simpleStep)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(0, simpleStep)));
        possibleMoves.removeIf(it -> !ValidatorLimitsBoard.getInstance().isWithinLimits(it));
        possibleMoves.removeIf(it -> piece.sameColor(it));
    }
}
