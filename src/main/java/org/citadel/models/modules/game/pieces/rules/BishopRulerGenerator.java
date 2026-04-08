package org.citadel.models.modules.game.pieces.rules;

import static org.citadel.models.modules.game.pieces.rules.strategies.BuilderMovementStrategy.buildBishopMovements;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.List;

public class BishopRulerGenerator implements MovementRuleGenerator {

    private static BishopRulerGenerator instance;

    private BishopRulerGenerator() {
    }

    public static BishopRulerGenerator getInstance() {
        if (instance == null) {
            instance = new BishopRulerGenerator();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Piece piece) {
        return buildBishopMovements(piece);
    }
}