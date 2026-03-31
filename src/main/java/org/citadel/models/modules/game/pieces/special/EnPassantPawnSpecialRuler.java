package org.citadel.models.modules.game.pieces.special;

import java.util.ArrayList;

import org.citadel.models.modules.game.pieces.Pawn;

public class EnPassantPawnSpecialRuler extends SpecialMovesRuler {

    public EnPassantPawnSpecialRuler(Pawn pawn) {
        super(pawn);
    }

    @Override
    public void generateMovements() {
        movements = new ArrayList<>();
    }
}
