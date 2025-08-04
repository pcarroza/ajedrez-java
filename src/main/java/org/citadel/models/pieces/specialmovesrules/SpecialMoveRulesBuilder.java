package org.citadel.models.pieces.specialmovesrules;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;

public abstract class SpecialMoveRulesBuilder {

    protected Piece piece;

    protected List<Coordinate> movements;

    SpecialMoveRulesBuilder(Piece piece) {
        this.piece = piece;
    }

    public boolean isMovementValid(Coordinate target) {
        return movements.contains(target);
    }

    public List<Coordinate> getMovements() {
        return movements;
    }

    public abstract void buildMovements();
}
