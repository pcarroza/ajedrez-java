package org.citadel.models.modules.game.pieces;

import static org.citadel.models.modules.game.pieces.rules.MovementRulerFacade.getQueenMoveRulesBuilder;

import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.visitors.PieceVisitor;

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