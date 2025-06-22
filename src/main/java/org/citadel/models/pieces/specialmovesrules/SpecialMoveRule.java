package org.citadel.models.pieces.specialmovesrules;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class SpecialMoveRule {

    private Piece piece;

    private List<Coordinate> movements;

    SpecialMoveRule(Piece piece) {
        this.piece = piece;
    }

    public void buildMovements() {
        movements = new ArrayList<>();
    }

    public boolean isMovementValid(Coordinate target) {
        return movements.contains(target);
    }

    public List<Coordinate> getMovements() {
        return movements;
    }
}
