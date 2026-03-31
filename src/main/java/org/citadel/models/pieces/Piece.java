package org.citadel.models.pieces;

import java.util.ArrayList;
import java.util.List;

import org.citadel.models.pieces.enums.Player;
import org.citadel.models.pieces.rules.MovementBaseGenerator;
import org.citadel.models.pieces.visitors.PieceVisitor;

public abstract class Piece extends SubjectPiece implements SelectedPiece {

    protected MovementBaseGenerator movementBaseGenerator;

    private Coordinate coordinate;

    protected final Player player;

    protected List<Coordinate> validMovements;

    protected Piece(Coordinate position, Player player) {
        this.coordinate = position;
        this.player = player;
        validMovements = new ArrayList<>();
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

    public boolean isMovementValid(Coordinate target) {
        return validMovements.contains(target.copy());
    }

    public void generateMovements() {
        this.validMovements = movementBaseGenerator.generate(this);
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

    public boolean isAt(Coordinate coordinate) {
        return getCoordinate().equals(coordinate);
    }

    public abstract void accept(PieceVisitor visitor);
}
