package org.citadel.models.modules.game.pieces.special;

import java.util.ArrayList;
import java.util.List;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.enums.Player;

public class InStepPawnRulerGenerator extends SpecialRulesGenerator {

    private static final int IN_STEP_ROW_WHITE = 5;

    private static final int IN_STEP_ROW_BLACK = 4;

    private final Pawn pawn;

    public InStepPawnRulerGenerator(Pawn pawn) {
        this.pawn = pawn;
    }

    @Override
    public void generate() {
        movements = new ArrayList<>();

        if (!isOnEnPassantRow())
            return;

        List.of(pawn.getDiagonalLeft(), pawn.getDiagonalRight())
                .stream()
                .filter(diagonal -> ValidatorLimitsBoard.getInstance().isWithinLimits(diagonal))
                .filter(this::hasVulnerableRivalPawnBeside)
                .forEach(movements::add);
    }

    private boolean isOnEnPassantRow() {
        int expectedRow = pawn.getPlayer() == Player.WHITE ? IN_STEP_ROW_WHITE : IN_STEP_ROW_BLACK;
        return pawn.getCoordinate().row() == expectedRow;
    }

    private boolean hasVulnerableRivalPawnBeside(Coordinate diagonal) {
        Coordinate rivalCoordinate = new Coordinate(pawn.getCoordinate().row(), diagonal.column());
        return pawn.isVulnerablePawnAt(rivalCoordinate);
    }
}
