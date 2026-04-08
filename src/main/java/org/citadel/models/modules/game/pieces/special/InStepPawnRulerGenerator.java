package org.citadel.models.modules.game.pieces.special;

import java.util.ArrayList;
import java.util.List;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Pawn;

public class InStepPawnRulerGenerator extends SpecialRulesGenerator {

    private final Pawn pawn;

    public InStepPawnRulerGenerator(Pawn pawn) {
        this.pawn = pawn;
    }

    @Override
    public void generate() {
        movements = new ArrayList<>();

        if (!pawn.isOnEnPassantRow())
            return;

        List.of(pawn.getDiagonalLeft(), pawn.getDiagonalRight())
                .stream()
                .filter(diagonal -> ValidatorLimitsBoard.getInstance().isWithinLimits(diagonal))
                .filter(this::hasVulnerableRivalPawnBeside)
                .forEach(movements::add);
    }

    private boolean hasVulnerableRivalPawnBeside(Coordinate diagonal) {
        Coordinate rivalCoordinate = new Coordinate(pawn.getCoordinate().row(), diagonal.column());
        return pawn.isVulnerablePawnAt(rivalCoordinate);
    }
}
