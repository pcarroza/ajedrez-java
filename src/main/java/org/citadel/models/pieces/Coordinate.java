package org.citadel.models.pieces;

import org.jetbrains.annotations.NotNull;

public record Coordinate(int row, int column) {

    public Coordinate(int row) {
        this(row, 0);
    }

    public Coordinate() {
        this(0, 0);
    }

    public Coordinate getDisplacedBy(Coordinate increment, Coordinate vector) {
        return getDisplacedBy(increment).scaleBy(vector);
    }

    public Coordinate getDisplacedBy(Coordinate increment) {
        return new Coordinate(row() + increment.row(), column() + increment.column());
    }

    public Coordinate getDisplacedBy(int increment) {
        return new Coordinate(row() + increment, column() + increment);
    }

    public Coordinate scaleBy(Coordinate vector) {
        return new Coordinate(row() * vector.row(), column() * vector.column());
    }

    public Coordinate copy() {
        return new Coordinate(this.row(), this.column());
    }

    @NotNull
    @Override
    public String toString() {
        return "Coordinate(" + row + ", " + column + ")";
    }
}
