package org.citadel.models.pieces.rules;

import static org.citadel.models.pieces.rules.strategies.BuilderMovementStrategy.buildRookMovements;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;

public class RookGenerator extends MovementBaseGenerator {

    private static RookGenerator instance;

    private RookGenerator() {
    }

    public static RookGenerator getInstance() {
        if (instance == null) {
            instance = new RookGenerator();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Piece piece) {
        return buildRookMovements(piece);
    }
}