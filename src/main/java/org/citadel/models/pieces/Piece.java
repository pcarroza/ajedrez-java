package org.citadel.models.pieces;

import java.util.List;

import org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGenerator;

public abstract class Piece extends SubjectPiece implements SelectedPiece {

    protected MovementRulesBaseGenerator basedGenerator;

    private Coordinate coordinate;

    protected final Player player;

    protected List<Coordinate> validMovements;

    protected Piece(Coordinate position, Player player) {
        this.coordinate = position;
        this.player = player;
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
        return basedGenerator.isMovementValid(target.copy());
    }

    public void generateMovements() {
        basedGenerator.generate();
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

    public boolean isVulnerablePawn() {
        return false;
    }
}
