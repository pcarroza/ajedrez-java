package org.citadel.models.pieces;

import org.citadel.models.pieces.rulesofmovements.MoveRulesManager;

public abstract class Piece extends SubjectPiece implements SelectablePiece {

    protected MoveRulesManager moveRulesManager;

    private Coordinate coordinate;

    protected final Color color;

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
        return moveRulesManager.isMovementValid(target.clone());
    }

    public void buildMovements() {
        moveRulesManager.buildMovements();
    }

    public void notifiesMovementsToTheBoard() {
        notify(moveRulesManager.getMovements());
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
