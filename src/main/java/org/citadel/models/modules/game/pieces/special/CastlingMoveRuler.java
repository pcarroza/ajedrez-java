package org.citadel.models.modules.game.pieces.special;

import java.util.ArrayList;

import org.citadel.models.modules.game.pieces.King;

public class CastlingMoveRuler extends SpecialMovesRuler {

    public CastlingMoveRuler(King king) {
        super(king);
    }

    @Override
    public void generateMovements() {
        movements = new ArrayList<>();
    }
}
