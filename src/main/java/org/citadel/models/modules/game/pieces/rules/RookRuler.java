package org.citadel.models.modules.game.pieces.rules;

import static org.citadel.models.modules.game.pieces.rules.strategies.BuilderMovementStrategy.buildRookMovements;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

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