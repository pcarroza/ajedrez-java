package org.citadel.models.pieces.rules;

import static org.citadel.models.pieces.rules.strategies.BuilderMovementStrategy.buildBishopMovements;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;

public class BishopGenerator extends MovementBaseGenerator {

    private static BishopGenerator instance;

    private BishopGenerator() {
    }

    public static BishopGenerator getInstance() {
        if (instance == null) {
            instance = new BishopGenerator();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Piece piece) {
        return buildBishopMovements(piece);
    }
}