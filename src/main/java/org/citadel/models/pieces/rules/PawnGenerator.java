package org.citadel.models.pieces.rules;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Pawn;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class PawnGenerator extends MovementBaseGenerator {

    private static PawnGenerator instance;

    private PawnGenerator() {
    }

    public static PawnGenerator getInstance() {
        if (instance == null) {
            instance = new PawnGenerator();
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