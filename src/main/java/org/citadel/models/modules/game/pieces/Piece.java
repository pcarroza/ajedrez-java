package org.citadel.models.modules.game.pieces;

import java.util.ArrayList;
import java.util.List;

import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.rules.MovementRuleGenerator;

public abstract class Piece extends SubjectPiece implements SelectedPiece {

    protected MovementRuleGenerator movementBaseGenerator;

    private Coordinate coordinate;

    protected final Player player;

    protected List<Coordinate> movements;

    protected Piece(Coordinate position, Player player) {
        this.coordinate = position;
        this.player = player;
        this.movements = new ArrayList<>();
    }

    protected void set(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void put(Coordinate target) {
        set(target.copy());
    }

    public Player getPlayer() {
        return player;
    }

    public List<Coordinate> getMovements() {
        return movements;
    }

    @Override
    public boolean isMovementValid(Coordinate target) {
        return movements.contains(target.copy());
    }

    @Override
    public void generateMovements() {
        this.movements = movementBaseGenerator.generate(this);
    }

    public Coordinate getDisplacedBy(int displacement) {
        return coordinate.getDisplacedBy(displacement);
    }

    public Coordinate getDisplacedBy(Coordinate displacement) {
        return coordinate.getDisplacedBy(displacement);
    }

    public Coordinate getDisplacedBy(Coordinate displacement, Coordinate vector) {
        return coordinate.getDisplacedBy(displacement, vector);
    }

    public boolean isAt(Coordinate coordinate) {
        return this.coordinate.equals(coordinate);
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public boolean isRookAvailableForCastling() {
        return false;
    }

    public boolean isPromoted() {
        return false;
    }

    public boolean isVulnerableToEnPassant() {
        return false;
    }

    public List<Coordinate> getEnPassantDiagonals() {
        return List.of();
    }

    public List<Coordinate> getSpecialMovements() {
        return List.of();
    }

    public String getSymbol() {
        return "";
    }

    public boolean isPawnPromoted() {
        return false;
    }

    public boolean isKing() {
        return false;
    }

    public boolean isRook() {
        return false;
    }

    public boolean isPawn() {
        return false;
    }
}