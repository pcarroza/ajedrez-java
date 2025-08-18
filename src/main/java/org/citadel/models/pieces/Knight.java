package org.citadel.models.pieces;

import static org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGeneratorFacade.createKnightMoveRulesBuilder;

public class Knight extends Piece {

    public Knight(Coordinate coordinate, Color color) {
        super(coordinate, color);
        basedGenerator = createKnightMoveRulesBuilder(this);
    }
}
