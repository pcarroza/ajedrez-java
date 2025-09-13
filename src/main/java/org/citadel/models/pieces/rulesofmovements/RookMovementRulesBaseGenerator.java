package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Piece;

import static org.citadel.models.pieces.rulesofmovements.commonmovementstrategy.BuilderMovementStrategy.buildRookMovements;

public class RookMovementRulesBaseGenerator extends MovementRulesBaseGenerator {

    public RookMovementRulesBaseGenerator(Piece piece) {
        super(piece);
    }

    @Override
    public void generate() {
        possibleMoves.clear();
        possibleMoves.addAll(buildRookMovements(piece));
    }
}