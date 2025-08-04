package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Piece;

import static org.citadel.models.pieces.rulesofmovements.commonmovementstrategy.BuilderMovementStrategy.buildRookMovements;

public class RookMovementRuleBuilder extends MovementRuleBuilder {

    public RookMovementRuleBuilder(Piece piece) {
        super(piece);
    }

    @Override
    public void buildMovements() {
        possibleMoves.addAll(buildRookMovements(piece));
    }
}