package org.citadel.models.pieces.rulesofmovements;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Pawn;
import org.citadel.models.pieces.Piece;

public class PawnMovementRulesBaseGenerator extends MovementRulesBaseGenerator {

    private Pawn pawn;

    public PawnMovementRulesBaseGenerator(Piece piece) {
        set(piece);
    }

    @Override
    public void set(Piece piece) {
        pawn = (Pawn) piece;
    }

    @Override
    public void generate() {
        possibleMoves.clear();

        if (pawn.canAdvanceOne())
            possibleMoves.add(pawn.getForwardOne());

        if (pawn.canAdvanceTwo())
            possibleMoves.add(pawn.getForwardTwo());

        if (pawn.canCaptureLeft())
            possibleMoves.add(pawn.getDiagonalLeft());

        if (pawn.canCaptureRight())
            possibleMoves.add(pawn.getDiagonalRight());

        possibleMoves.removeIf( it -> !ValidatorLimitsBoard.getInstance().isWithinLimits(it));
    }
}