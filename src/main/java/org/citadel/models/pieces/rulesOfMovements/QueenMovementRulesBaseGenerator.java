package org.citadel.models.pieces.rulesOfMovements;

import static org.citadel.models.pieces.rulesOfMovements.strategies.BuilderMovementStrategy.buildQueenMovements;

import org.citadel.models.pieces.Piece;

public class QueenMovementRulesBaseGenerator extends MovementRulesBaseGenerator {

    public QueenMovementRulesBaseGenerator(Piece piece) {
        super(piece);
    }

    @Override
    public void generate() {
        possibleMoves.clear();
        possibleMoves.addAll(buildQueenMovements(piece));
    }
}