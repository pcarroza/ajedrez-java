package org.citadel.models.modules.game.pieces.rules;

import static org.citadel.models.modules.game.pieces.rules.GeneratorLegalMoves.generateLegalMoves;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;

import java.util.List;

public class KingRulesGenerator implements MovementRuleGenerator<King> {

    private static KingRulesGenerator instance;

    private KingRulesGenerator() {
    }

    public static KingRulesGenerator getInstance() {
        if (instance == null) {
            instance = new KingRulesGenerator();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(King piece) {
        final int simpleStep = 1;

        var offsets = List.of(
                new Coordinate(simpleStep, -simpleStep),
                new Coordinate(simpleStep, 0),
                new Coordinate(simpleStep, simpleStep),
                new Coordinate(-simpleStep, 0),
                new Coordinate(-simpleStep, -simpleStep),
                new Coordinate(-simpleStep, simpleStep),
                new Coordinate(0, -simpleStep),
                new Coordinate(0, simpleStep));

        return generateLegalMoves(piece, offsets);
    }
}