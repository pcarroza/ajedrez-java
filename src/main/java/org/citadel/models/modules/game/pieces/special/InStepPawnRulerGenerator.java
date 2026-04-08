package org.citadel.models.modules.game.pieces.special;

import java.util.ArrayList;
import java.util.List;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Piece;

public class InStepPawnRulerGenerator extends SpecialRulesGenerator {

    @Override
    public List<Coordinate> generate(Piece piece) {
        Pawn pawn = (Pawn) piece;
        assert !pawn.isOnEnPassantRow();

        List<Coordinate> movements = new ArrayList<>();

        List.of(pawn.getDiagonalLeft(), pawn.getDiagonalRight())
                .stream()
                .filter((it) -> ValidatorLimitsBoard.getInstance().isWithinLimits(it))
                .filter((it) -> pawn.hasVulnerableRivalPawnBeside(it))
                .forEach(movements::add);

        return movements;
    }
}
