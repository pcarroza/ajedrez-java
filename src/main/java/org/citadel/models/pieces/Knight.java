package org.citadel.models.pieces;

import static org.citadel.models.pieces.rulesofmovements.FacadeMotionManager.createKnightMoveRulesManager;

public class Knight extends Piece {

    public Knight(Coordinate coordinate, Color color) {
        super(coordinate, color);
        moveRulesManager = createKnightMoveRulesManager(this);
    }
}
