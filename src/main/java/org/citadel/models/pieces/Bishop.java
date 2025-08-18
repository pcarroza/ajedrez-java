package org.citadel.models.pieces;

import static org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGeneratorFacade.createBishopMoveRulesBuilder;

public class Bishop extends Piece {

    public Bishop(Coordinate coordinate, Color color) {
        super(coordinate, color);
        basedGenerator = createBishopMoveRulesBuilder(this);
    }
}
