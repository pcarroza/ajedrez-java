package org.citadel.models.pieces.rulesOfMovements;

import static org.citadel.models.pieces.rulesOfMovements.strategies.BuilderMovementStrategy.buildBishopMovements;

import org.citadel.models.pieces.Piece;

public class BishopMovementRulesBaseGenerator extends MovementRulesBaseGenerator {

    public BishopMovementRulesBaseGenerator(Piece piece) {
        super(piece);
    }

    @Override
    public void generate() {
        possibleMoves.clear();
        possibleMoves.addAll(buildBishopMovements(piece));
    }
}