package org.citadel.models.pieces;

import static org.citadel.models.pieces.rulesofmovements.FacadeMotionManager.createRookMoveRulesManager;

public class Rook extends Piece {

    private boolean isMoved = false;

    public Rook(Coordinate coordinate, Color color) {
        super(coordinate, color);
        moveRulesManager = createRookMoveRulesManager(this);
    }

    @Override
    public void put(Coordinate coordinate) {
        if (isNotMoved()) {
            close();
        }
        super.put(coordinate);
    }

    @Override
    public boolean isNotMoved() {
        return !isMoved;
    }

    private void close() {
        isMoved = !isMoved;
    }

    @Override
    public boolean isRook() {
        return true;
    }
}
