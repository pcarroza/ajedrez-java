package org.citadel.models.modules.game.pieces.special;

import java.util.ArrayList;

import org.citadel.models.modules.game.pieces.Pawn;

public class EnPassantPawnSpecialRuleGenerator extends SpecialMovesRulesGenerator {

    public EnPassantPawnSpecialRuleGenerator(Pawn pawn) {
        super(pawn);
    }

    @Override
    public void generateMovements() {
        movements = new ArrayList<>();
    }
}
