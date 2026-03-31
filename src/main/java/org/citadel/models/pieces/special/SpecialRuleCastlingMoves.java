package org.citadel.models.pieces.special;

import java.util.ArrayList;

import org.citadel.models.pieces.King;

public class SpecialRuleCastlingMoves extends SpecialMovesRulesGenerator {

    public SpecialRuleCastlingMoves(King king) {
        super(king);
    }

    @Override
    public void generateMovements() {
        movements = new ArrayList<>();
    }
}
