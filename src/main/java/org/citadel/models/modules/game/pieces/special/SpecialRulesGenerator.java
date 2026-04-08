package org.citadel.models.modules.game.pieces.special;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.List;

public abstract class SpecialRulesGenerator {

    protected List<Coordinate> movements;

    SpecialRulesGenerator() {
    }

    public boolean isMovementValid(Coordinate target) {
        return movements.contains(target);
    }

    public List<Coordinate> getMovements() {
        return movements;
    }

    public abstract List<Coordinate> generate(Piece piece);
}
