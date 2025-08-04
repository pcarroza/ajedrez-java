package org.citadel.models.pieces;

import static org.citadel.models.pieces.rulesofmovements.MovementBuilderFacade.createRookMoveRulesBuilder;

public class Rook extends Piece {

    private boolean isMoved = false;

    public Rook(Coordinate coordinate, Color color) {
        super(coordinate, color);
        movementRuleBuilder = createRookMoveRulesBuilder(this);
    }

    @Override
    public void put(Coordinate target) {
        if (isNotMoved()) {
            close();
        }
        super.put(target.copy());
    }

    private void close() {
        isMoved = !isMoved;
    }

    @Override
    public boolean isNotMoved() {
        return !isMoved;
    }

    @Override
    public boolean isRook() {
        return true;
    }
}
