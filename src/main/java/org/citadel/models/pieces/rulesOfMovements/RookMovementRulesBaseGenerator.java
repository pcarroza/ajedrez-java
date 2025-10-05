package org.citadel.models.pieces.rulesOfMovements;

import static org.citadel.models.pieces.rulesOfMovements.strategies.BuilderMovementStrategy.buildRookMovements;

import org.citadel.models.pieces.Piece;

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