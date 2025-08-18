package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Piece;

import static org.citadel.models.pieces.rulesofmovements.commonmovementstrategy.BuilderMovementStrategy.buildBishopMovements;

public class BishopMovementRulesBaseGenerator extends MovementRulesBaseGenerator {

    public BishopMovementRulesBaseGenerator(Piece piece) {
        super(piece);
    }

    @Override
    public void generate() {
        possibleMoves.addAll(buildBishopMovements(piece));
    }
}