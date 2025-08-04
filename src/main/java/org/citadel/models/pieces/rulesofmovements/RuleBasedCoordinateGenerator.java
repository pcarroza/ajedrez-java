package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;

public abstract class RuleBasedCoordinateGenerator {

    protected Piece piece;

    protected List<Coordinate> possibleMoves;

    RuleBasedCoordinateGenerator(Piece piece) {
        this.piece = piece;
    }

    RuleBasedCoordinateGenerator() {
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

    public abstract void buildMovements();
}