package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Piece;

import static org.citadel.models.pieces.rulesofmovements.commonmovementstrategy.BuilderMovementStrategy.buildQueenMovements;

public class QueenRuleBasedCoordinateGenerator extends RuleBasedCoordinateGenerator {

    public QueenRuleBasedCoordinateGenerator(Piece piece) {
        super(piece);
    }

    @Override
    public void buildMovements() {
        possibleMoves.addAll(buildQueenMovements(piece));
    }
}