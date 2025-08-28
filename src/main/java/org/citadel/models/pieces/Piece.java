package org.citadel.models.pieces;

import java.util.ArrayList;
import java.util.List;

import org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGenerator;

public abstract class Piece extends SubjectPiece implements SelectedPiece {

    public abstract void accept(PieceVisitor visitor);

    protected MovementRulesBaseGenerator basedGenerator;

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
        return basedGenerator.getMovements();
    }

    public boolean isMovementValid(Coordinate target) {
        return basedGenerator.isMovementValid(target.copy());
    }

    public void generateMovements() {
        basedGenerator.generate();
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
}
