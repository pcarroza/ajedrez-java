package org.citadel.models.pieces.rules;

import static org.citadel.models.pieces.rules.strategies.BuilderMovementStrategy.buildRookMovements;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;

public class RookRuler extends MovementRuler {

    private static RookRuler instance;

    private RookRuler() {
    }

    public static RookRuler getInstance() {
        if (instance == null) {
            instance = new RookRuler();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Piece piece) {
        return buildRookMovements(piece);
    }
}