package org.citadel.models.modules.game.pieces;

import static org.citadel.models.modules.game.pieces.rules.MovementRulerFacade.getRookMoveRulesBuilder;

import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.visitors.PieceVisitor;

public class Rook extends Piece {

    private boolean isMoved = false;

    public boolean isMoved() {
        return isMoved;
    }

    public Rook(Coordinate coordinate, Player player) {
        super(coordinate, player);
        movementBaseGenerator = getRookMoveRulesBuilder();
    }

    @Override
    public void put(Coordinate target) {
        if (!isMoved) {
            close();
        }
        super.put(target.copy());
    }

    private void close() {
        isMoved = !isMoved;
    }

    @Override
    public void accept(PieceVisitor pieceVisitor) {
        pieceVisitor.visit(this);
    }
}