package org.citadel.models.pieces;

import static org.citadel.models.pieces.rules.MovementBaseGeneratorFacade.getQueenMoveRulesBuilder;

import org.citadel.models.pieces.enums.Player;
import org.citadel.models.pieces.visitors.PieceVisitor;

public class Queen extends Piece {

    public Queen(Coordinate coordinate, Player player) {
        super(coordinate, player);
        movementBaseGenerator = getQueenMoveRulesBuilder();
    }

    @Override
    public void accept(PieceVisitor pieceVisitor) {
        pieceVisitor.visit(this);
    }
}