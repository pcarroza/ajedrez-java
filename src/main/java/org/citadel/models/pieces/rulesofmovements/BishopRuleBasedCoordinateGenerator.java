package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Piece;

import static org.citadel.models.pieces.rulesofmovements.commonmovementstrategy.BuilderMovementStrategy.buildBishopMovements;

public class BishopRuleBasedCoordinateGenerator extends RuleBasedCoordinateGenerator {

    public BishopRuleBasedCoordinateGenerator(Piece piece) {
        super(piece);
    }

    @Override
    public void buildMovements() {
        possibleMoves.addAll(buildBishopMovements(piece));
    }
}