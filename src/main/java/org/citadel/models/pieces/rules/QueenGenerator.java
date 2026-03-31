package org.citadel.models.pieces.rules;

import static org.citadel.models.pieces.rules.strategies.BuilderMovementStrategy.buildQueenMovements;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;

public class QueenGenerator extends MovementBaseGenerator {

    private static QueenGenerator instance;

    private QueenGenerator() {
    }

    public static QueenGenerator getInstance() {
        if (instance == null) {
            instance = new QueenGenerator();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Piece piece) {
        return buildQueenMovements(piece);
    }
}