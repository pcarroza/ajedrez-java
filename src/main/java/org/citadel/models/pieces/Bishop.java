package org.citadel.models.pieces;

import static org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGeneratorFacade.createBishopMoveRulesBuilder;

public class Bishop extends Piece {

    @Override
    public void accept(PieceVisitor visitor) {
        visitor.visit(this);
    }

    public Bishop(Coordinate coordinate, Player player) {
        super(coordinate, player);
        basedGenerator = createBishopMoveRulesBuilder(this);
    }
}
