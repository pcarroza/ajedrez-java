package org.citadel.models.pieces.rulesOfMovements;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public abstract class MovementRulesBaseGenerator {

    protected Piece piece;

    protected List<Coordinate> possibleMoves;

    MovementRulesBaseGenerator(Piece piece) {
        possibleMoves = new ArrayList<>();
        this.piece = piece;
    }

    MovementRulesBaseGenerator() {
    }

    public void set(Piece piece) {
        this.piece = piece;
    }

    public boolean isMovementValid(Coordinate coordinate) {
        return possibleMoves.contains(coordinate);
    }

    public List<Coordinate> getMovements() {
        return possibleMoves;
    }

    public abstract void generate();
}