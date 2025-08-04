package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;

public abstract class MovementRuleBuilder {

    protected Piece piece;

    protected List<Coordinate> possibleMoves;

    MovementRuleBuilder(Piece piece) {
        this.piece = piece;
    }

    MovementRuleBuilder() {
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