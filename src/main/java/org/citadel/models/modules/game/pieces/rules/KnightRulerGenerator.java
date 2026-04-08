package org.citadel.models.modules.game.pieces.rules;

import static org.citadel.models.modules.game.pieces.rules.GeneratorLegalMoves.generateLegalMoves;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.List;

public class KnightRulerGenerator extends MovementRuleGenerator {

    private static KnightRulerGenerator instance;

    private KnightRulerGenerator() {
    }

    public static KnightRulerGenerator getInstance() {
        if (instance == null) {
            instance = new KnightRulerGenerator();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Piece piece) {
        final int doubleStep = 2;
        final int simpleStep = 1;

        var offsets = List.of(
                new Coordinate(doubleStep, simpleStep),
                new Coordinate(simpleStep, doubleStep),
                new Coordinate(-simpleStep, doubleStep),
                new Coordinate(-doubleStep, -simpleStep),
                new Coordinate(-simpleStep, -doubleStep),
                new Coordinate(simpleStep, -doubleStep),
                new Coordinate(doubleStep, -simpleStep),
                new Coordinate(-doubleStep, simpleStep));

        return generateLegalMoves(piece, offsets);
    }
}