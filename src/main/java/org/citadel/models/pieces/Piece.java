package org.citadel.models.pieces;

import java.util.List;

import org.citadel.models.pieces.rulesofmovements.MoveRulesManager;

public abstract class Piece extends SubjectPiece implements SelectedPiece {

    protected MoveRulesManager moveRulesManager;

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

    public Coordinate getDisplacedCoordinateBy(int displacement) {
        return getCoordinate().getDisplacedBy(displacement);
    }

    public Coordinate getDisplacedCoordinateBy(Coordinate displacement) {
        return getCoordinate().getDisplacedBy(displacement);
    }

    public Coordinate getDisplacedCoordinateBy(Coordinate displacement, Coordinate vector) {
        return getCoordinate().getDisplacedBy(displacement, vector);
    }

    public boolean has(Coordinate coordinate) {
        return getCoordinate().equals(coordinate);
    }

    public boolean isMovementValid(Coordinate target) {
        return moveRulesManager.isMovementValid(target.copy());
    }

    public void buildMovements() {
        moveRulesManager.buildMovements();
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
