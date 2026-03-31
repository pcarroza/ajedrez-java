package org.citadel.models.modules.game.pieces.special;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.List;

public abstract class SpecialMovesRuler {

    protected Piece piece;

    protected List<Coordinate> movements;

    SpecialMovesRuler(Piece piece) {
        this.piece = piece;
    }

    public boolean isMovementValid(Coordinate target) {
        return movements.contains(target);
    }

    public List<Coordinate> getMovements() {
        return movements;
    }

    public abstract void generateMovements();
}
