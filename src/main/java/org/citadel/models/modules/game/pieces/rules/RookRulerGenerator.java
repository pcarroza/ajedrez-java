package org.citadel.models.modules.game.pieces.rules;

import static org.citadel.models.modules.game.pieces.rules.strategies.BuilderMovementStrategy.buildRookMovements;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Rook;

import java.util.List;

public class RookRulerGenerator implements MovementRuleGenerator<Rook> {

    private static RookRulerGenerator instance;

    private RookRulerGenerator() {
    }

    public static RookRulerGenerator getInstance() {
        if (instance == null) {
            instance = new RookRulerGenerator();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Rook piece) {
        return buildRookMovements(piece);
    }
}