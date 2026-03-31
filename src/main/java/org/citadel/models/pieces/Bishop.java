package org.citadel.models.pieces;

import static org.citadel.models.pieces.rules.MovementRulerFacade.getBishopMoveRulesBuilder;

import org.citadel.models.pieces.enums.Player;
import org.citadel.models.pieces.visitors.PieceVisitor;

public class Bishop extends Piece {

    public Bishop(Coordinate coordinate, Player player) {
        super(coordinate, player);
        movementBaseGenerator = getBishopMoveRulesBuilder();
    }

    @Override
    public void accept(PieceVisitor pieceVisitor) {
        pieceVisitor.visit(this);
    }
}