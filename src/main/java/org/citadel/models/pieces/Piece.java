package org.citadel.models.pieces;

import java.util.List;

import org.citadel.models.pieces.rulesofmovements.MovementRuleBuilder;

public abstract class Piece extends SubjectPiece implements SelectedPiece {

    protected MovementRuleBuilder movementRuleBuilder;

    private Coordinate coordinate;

    protected final Color color;

    protected List<Coordinate> validMovements;

    protected Piece(Coordinate position, Color color) {
        this.coordinate = position;
        this.color = color;
    }

    protected void set(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void put(Coordinate target) {
        set(target.copy());
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public List<Coordinate> getValidMovements() {
        return validMovements;
    }

    public Coordinate getDisplacedBy(int displacement) {
        return getCoordinate().getDisplacedBy(displacement);
    }

    public Coordinate getDisplacedBy(Coordinate displacement) {
        return getCoordinate().getDisplacedBy(displacement);
    }

    public Coordinate getDisplacedBy(Coordinate displacement, Coordinate vector) {
        return getCoordinate().getDisplacedBy(displacement, vector);
    }

    public boolean has(Coordinate coordinate) {
        return getCoordinate().equals(coordinate);
    }

    public boolean isMovementValid(Coordinate target) {
        return movementRuleBuilder.isMovementValid(target.copy());
    }

    public void buildMovements() {
        movementRuleBuilder.buildMovements();
    }

    public boolean isThePawnPromoted() {
        return false;
    }

    public boolean isNotMoved() {
        return true;
    }

    public boolean isKing() {
        return false;
    }

    public boolean isRook() {
        return false;
    }
}
