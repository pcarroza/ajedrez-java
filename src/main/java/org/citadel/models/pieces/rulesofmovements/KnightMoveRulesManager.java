package org.citadel.models.pieces.rulesofmovements;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;

public class KnightMoveRulesManager extends MoveRulesManager {

    public KnightMoveRulesManager(Piece piece) {
        super(piece);
    }

    @Override
    public void buildMovements() {
        final int doubleStep = 2;
        final int simpleStep = 1;
        possibleMoves = new ArrayList<>();
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(doubleStep, -simpleStep)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(doubleStep, simpleStep)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(simpleStep, doubleStep)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(-simpleStep, doubleStep)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(-doubleStep, -simpleStep)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(-simpleStep, -doubleStep)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(simpleStep, -doubleStep)));
        possibleMoves.add(piece.getDisplacedCoordinateBy(new Coordinate(simpleStep, doubleStep)));
        possibleMoves.removeIf(it -> !ValidatorLimitsBoard.getInstance().isWithinLimits(it));
        possibleMoves.removeIf(it -> piece.sameColor(it));
    }
}