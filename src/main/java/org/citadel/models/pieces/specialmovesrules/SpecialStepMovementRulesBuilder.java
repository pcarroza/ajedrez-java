package org.citadel.models.pieces.specialmovesrules;

import java.util.ArrayList;

import org.citadel.models.pieces.Pawn;

public class SpecialStepMovementRulesBuilder extends SpecialMoveRulesBuilder {

    public SpecialStepMovementRulesBuilder(Pawn pawn) {
        super(pawn);
    }

    @Override
    public void buildMovements() {
        movements = new ArrayList<>();
    }
}
