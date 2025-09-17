package org.citadel.models.pieces;

public class Coordinate {

    private final int row;

    private final int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Coordinate(int row) {
        this(row, 0);
    }

    public Coordinate() {
        this(0, 0);
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public Coordinate getDisplacedBy(Coordinate increment, Coordinate vector) {
        return getDisplacedBy(increment).scaleBy(vector);
    }

    public Coordinate getDisplacedBy(Coordinate increment) {
        return new Coordinate(getRow() + increment.getRow(), getColumn() + increment.getColumn());
    }

    public Coordinate getDisplacedBy(int increment) {
        return new Coordinate(getRow() + increment, getColumn() + increment);
    }

    public Coordinate scaleBy(Coordinate vector) {
        return new Coordinate(getRow() * vector.getRow(), getColumn() * vector.getColumn());
    }

    public Coordinate copy() {
        return new Coordinate(this.getRow(), this.getColumn());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && column == that.column;
    }

    public String toString() {
        return "Coordinate(" + getRow() + ", " + getColumn() + ")";
    }
}
