package org.citadel.models.pieces.specialmovesrules;

import java.util.ArrayList;

import org.citadel.models.pieces.Pawn;

public class SpecialStepMovementRulesGenerator extends SpecialMovesRulesGenerator {

    public SpecialStepMovementRulesGenerator(Pawn pawn) {
        super(pawn);
    }

    @Override
    public void buildMovements() {
        movements = new ArrayList<>();
    }
}
