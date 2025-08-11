package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Piece;

import static org.citadel.models.pieces.rulesofmovements.commonmovementstrategy.BuilderMovementStrategy.buildRookMovements;

public class RookRuleBasedCoordinateGenerator extends RuleBasedCoordinateGenerator {

    public RookRuleBasedCoordinateGenerator(Piece piece) {
        super(piece);
    }

    @Override
    public void generate() {
        possibleMoves.addAll(buildRookMovements(piece));
    }
}