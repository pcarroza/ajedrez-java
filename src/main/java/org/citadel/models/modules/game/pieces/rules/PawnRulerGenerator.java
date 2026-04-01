package org.citadel.models.modules.game.pieces.rules;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class PawnRulerGenerator extends MovementRuleGenerator {

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
    public List<Coordinate> generate(Piece piece) {
        Pawn pawn = (Pawn) piece;
        List<Coordinate> possibleMoves = new ArrayList<>();

        if (pawn.canAdvanceOne())
            possibleMoves.add(pawn.getForwardOne());

        if (pawn.canAdvanceTwo())
            possibleMoves.add(pawn.getForwardTwo());

        if (pawn.canCaptureLeft())
            possibleMoves.add(pawn.getDiagonalLeft());

        if (pawn.canCaptureRight())
            possibleMoves.add(pawn.getDiagonalRight());

        possibleMoves.removeIf(it -> !ValidatorLimitsBoard.getInstance().isWithinLimits(it));
        return possibleMoves;
    }
}