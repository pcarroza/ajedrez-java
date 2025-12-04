package org.citadel.models.pieces.specialmovesrules;

import java.util.ArrayList;

import org.citadel.models.pieces.Pawn;

public class SpecialStepMovementRule extends SpecialMoveRule {

    public SpecialStepMovementRule(Pawn pawn) {
        super(pawn);
    }

    @Override
    public void buildMovements() {
        movements = new ArrayList<>();
    }
}
