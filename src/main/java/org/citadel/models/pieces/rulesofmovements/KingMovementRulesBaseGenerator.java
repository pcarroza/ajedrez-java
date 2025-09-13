package org.citadel.models.pieces.rulesofmovements;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;

public class KingMovementRulesBaseGenerator extends MovementRulesBaseGenerator {

    public KingMovementRulesBaseGenerator(Piece piece) {
        super(piece);
    }

    @Override
    public void generate() {
        final int simpleStep = 1;

        possibleMoves.clear();

        possibleMoves = List.of(
                piece.getDisplacedBy(new Coordinate(simpleStep, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(simpleStep, 0)),
                piece.getDisplacedBy(new Coordinate(simpleStep, simpleStep)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, 0)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(-simpleStep, simpleStep)),
                piece.getDisplacedBy(new Coordinate(0, -simpleStep)),
                piece.getDisplacedBy(new Coordinate(0, simpleStep)));

        possibleMoves.removeIf(it -> !ValidatorLimitsBoard.getInstance().isWithinLimits(it));
        possibleMoves.removeIf(it -> piece.isPieceCurrentPlayer(it));
    }
}
