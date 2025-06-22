package org.citadel.models.pieces;

import static org.citadel.models.pieces.rulesofmovements.FacadeMotionManager.createQueenMoveRulesManager;

public class Queen extends Piece {

    public Queen(Coordinate coordinate, Color color) {
        super(coordinate, color);
        moveRulesManager = createQueenMoveRulesManager(this);
    }
}
