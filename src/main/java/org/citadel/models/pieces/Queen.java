package org.citadel.models.pieces;

import static org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGeneratorFacade.createQueenMoveRulesBuilder;

public class Queen extends Piece {

    @Override
    public void accept(PieceVisitor visitor) {
        visitor.visit(this);
    }

    public Queen(Coordinate coordinate, Player player) {
        super(coordinate, player);
        basedGenerator = createQueenMoveRulesBuilder(this);
    }
}
