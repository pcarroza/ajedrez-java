package org.citadel.models.pieces;

import static org.citadel.models.pieces.rules.MovementBaseGeneratorFacade.getRookMoveRulesBuilder;

import org.citadel.models.pieces.enums.Player;
import org.citadel.models.pieces.visitors.PieceVisitor;

public class Rook extends Piece {

    private boolean isMoved = false;

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