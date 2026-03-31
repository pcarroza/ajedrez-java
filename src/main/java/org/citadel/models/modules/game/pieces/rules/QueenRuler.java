package org.citadel.models.modules.game.pieces.rules;

import static org.citadel.models.modules.game.pieces.rules.strategies.BuilderMovementStrategy.buildQueenMovements;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.List;

public class QueenRuler extends MovementRuler {

    private static QueenRuler instance;

    private QueenRuler() {
    }

    public static QueenRuler getInstance() {
        if (instance == null) {
            instance = new QueenRuler();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Piece piece) {
        return buildQueenMovements(piece);
    }
}