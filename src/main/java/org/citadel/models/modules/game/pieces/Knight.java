package org.citadel.models.modules.game.pieces;

import static org.citadel.models.modules.game.pieces.rules.MovementRulerFacade.getKnightMoveRulesBuilder;

import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.visitors.PieceVisitor;

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