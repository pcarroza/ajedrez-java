package org.citadel.models.pieces.specialmovesrules;

import java.util.ArrayList;

import org.citadel.models.pieces.Pawn;

public class EnPassantPawnSpecialRuleGenerator extends SpecialMovesRulesGenerator {

    public EnPassantPawnSpecialRuleGenerator(Pawn pawn) {
        super(pawn);
    }

    @Override
    public void generateMovements() {
        movements = new ArrayList<>();
    }
}
