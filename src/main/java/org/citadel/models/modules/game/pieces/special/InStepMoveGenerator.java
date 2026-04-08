package org.citadel.models.modules.game.pieces.special;

import java.util.List;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Pawn;

public class InStepMoveGenerator extends SpecialMoveGenerator<Pawn> {

    private static InStepMoveGenerator instance;

    private InStepMoveGenerator() {
    }

    public static InStepMoveGenerator getInstance() {
        if (instance == null) {
            instance = new InStepMoveGenerator();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generator(Pawn pawn) {
        List<Coordinate> movements = new java.util.ArrayList<>();
        if (!pawn.isOnEnPassantRow()) {
            return movements;
        }
        List.of(pawn.getDiagonalLeft(), pawn.getDiagonalRight())
                .stream()
                .filter(ValidatorLimitsBoard.getInstance()::isWithinLimits)
                .filter(pawn::hasVulnerableRivalPawnBeside)
                .forEach(movements::add);
        return movements;
    }
}
