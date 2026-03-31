package org.citadel.models.pieces.rules;

import static org.citadel.models.pieces.rules.strategies.BuilderMovementStrategy.buildBishopMovements;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;

public class BishopRuler extends MovementRuler {

    private static BishopRuler instance;

    private BishopRuler() {
    }

    public static BishopRuler getInstance() {
        if (instance == null) {
            instance = new BishopRuler();
        }
        return instance;
    }

    @Override
    public List<Coordinate> generate(Piece piece) {
        return buildBishopMovements(piece);
    }
}