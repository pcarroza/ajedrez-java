package org.citadel.models.pieces;

import static org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGeneratorFacade.createKnightMoveRulesBuilder;

public class Knight extends Piece {

    public Knight(Coordinate coordinate, Player player) {
        super(coordinate, player);
        basedGenerator = createKnightMoveRulesBuilder(this);
    }

    @Override
    public void accept(PieceVisitor pieceVisitor) {
        pieceVisitor.visit(this);
    }
}
