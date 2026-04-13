package org.citadel.models.modules.game.pieces.rules;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;

import java.util.ArrayList;
import java.util.List;

public class PawnRulerGenerator implements GeneratorMoveVisitor {

    private static PawnRulerGenerator instance;

    private List<Coordinate> possibleMoves;

    private PawnRulerGenerator() {
    }

    public static PawnRulerGenerator getInstance() {
        if (instance == null) {
            instance = new PawnRulerGenerator();
        }
        return instance;
    }

    public List<Coordinate> getPossibleMoves() {
        return possibleMoves;
    }

    public List<Coordinate> generate(Pawn pawn) {
        List<Coordinate> possibleMoves = new ArrayList<>();

        if (pawn.canAdvanceOne())
            addIfWithinLimits(possibleMoves, pawn.getForwardOne());

        if (pawn.canAdvanceTwo())
            addIfWithinLimits(possibleMoves, pawn.getForwardTwo());

        if (pawn.canCaptureLeft())
            addIfWithinLimits(possibleMoves, pawn.getDiagonalLeft());

        if (pawn.canCaptureRight())
            addIfWithinLimits(possibleMoves, pawn.getDiagonalRight());

        return possibleMoves;
    }

    private void addIfWithinLimits(List<Coordinate> possibleMoves, Coordinate coordinate) {
        if (ValidatorLimitsBoard.getInstance().isWithinLimits(coordinate)) {
            possibleMoves.add(coordinate);
        }
    }

    @Override
    public void visit(Pawn pawn) {
        this.possibleMoves = generate(pawn);
    }

    @Override
    public void visit(Rook rook) {
        // It does nothing
    }

    @Override
    public void visit(Knight knight) {
        // It does nothing
    }

    @Override
    public void visit(Bishop bishop) {
        // It does nothing
    }

    @Override
    public void visit(Queen queen) {
        // It does nothing
    }

    @Override
    public void visit(King king) {
        // It does nothing
    }
}