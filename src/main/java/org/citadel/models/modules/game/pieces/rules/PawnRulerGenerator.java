package org.citadel.models.modules.game.pieces.rules;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class PawnRulerGenerator implements MovementRuleGenerator<Pawn> {

    private static PawnRulerGenerator instance;

    private PawnRulerGenerator() {
    }

    public static PawnRulerGenerator getInstance() {
        if (instance == null) {
            instance = new PawnRulerGenerator();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Pawn pawn) {
        List<Coordinate> possibleMoves = new ArrayList<>();

        if (pawn.canAdvanceOne())
            addCoordinateIfWithinLimits(pawn, possibleMoves);

        if (pawn.canAdvanceTwo())
            addCoordinateIfWithinLimits(pawn, possibleMoves);

        if (pawn.canCaptureLeft())
            addCoordinateIfWithinLimits(pawn, possibleMoves);

        if (pawn.canCaptureRight())
            addCoordinateIfWithinLimits(pawn, possibleMoves);

        return possibleMoves;
    }

    public void addCoordinateIfWithinLimits(Pawn pawn, List<Coordinate> opponentPieces) {
        Coordinate coordinate = pawn.getCoordinate();
        if (ValidatorLimitsBoard.getInstance().isWithinLimits(coordinate)) {
            opponentPieces.add(coordinate);
        }
    }
}