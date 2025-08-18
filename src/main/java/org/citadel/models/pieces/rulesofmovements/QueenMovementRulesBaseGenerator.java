package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Piece;

import static org.citadel.models.pieces.rulesofmovements.commonmovementstrategy.BuilderMovementStrategy.buildQueenMovements;

public class QueenMovementRulesBaseGenerator extends MovementRulesBaseGenerator {

    public QueenMovementRulesBaseGenerator(Piece piece) {
        super(piece);
    }

    @Override
    public void generate() {
        possibleMoves.addAll(buildQueenMovements(piece));
    }
}