package org.citadel.models.pieces.specialmovesrules;

import java.util.ArrayList;

import org.citadel.models.pieces.King;

public class SpecialRuleCastlingMove extends SpecialMoveRule {

    public SpecialRuleCastlingMove(King king) {
        super(king);
    }

    @Override
    public void buildMovements() {
        movements = new ArrayList<>();
    }
}
