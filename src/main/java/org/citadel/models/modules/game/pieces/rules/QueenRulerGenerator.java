package org.citadel.models.modules.game.pieces.rules;

import static org.citadel.models.modules.game.pieces.rules.strategies.BuilderMovementStrategy.buildQueenMovements;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Queen;

import java.util.List;

public class QueenRulerGenerator implements MovementRuleGenerator<Queen> {

    private static QueenRulerGenerator instance;

    private QueenRulerGenerator() {
    }

    public static QueenRulerGenerator getInstance() {
        if (instance == null) {
            instance = new QueenRulerGenerator();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Queen piece) {
        return buildQueenMovements(piece);
    }
}