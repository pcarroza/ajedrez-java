package org.citadel.models.pieces;

import static org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGeneratorFacade.createBishopMoveRulesBuilder;

public class Bishop extends Piece {

    public Bishop(Coordinate coordinate, Player player) {
        super(coordinate, player);
        basedGenerator = createBishopMoveRulesBuilder(this);
    }



    @Override
    public void accept(PieceVisitor pieceVisitor) {
        pieceVisitor.visit(this);
    }
}
