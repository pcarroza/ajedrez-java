package org.citadel.models.pieces;

import static org.citadel.models.pieces.rules.MovementRulerFacade.getKnightMoveRulesBuilder;

import org.citadel.models.pieces.enums.Player;
import org.citadel.models.pieces.visitors.PieceVisitor;

public class Knight extends Piece {

    public Knight(Coordinate coordinate, Player player) {
        super(coordinate, player);
        movementBaseGenerator = getKnightMoveRulesBuilder();
    }

    @Override
    public void accept(PieceVisitor pieceVisitor) {
        pieceVisitor.visit(this);
    }
}