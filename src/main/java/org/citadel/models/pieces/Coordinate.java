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

    public Coordinate getDisplacedBy(Coordinate coordinate, Coordinate vector) {
        return getDisplacedBy(coordinate).scaleBy(vector);
    }

    public Coordinate getDisplacedBy(Coordinate offset) {
        return new Coordinate(getRow() + offset.getRow(), getColumn() + offset.getColumn());
    }

    public Coordinate getDisplacedBy(int displacement) {
        return new Coordinate(getRow() + displacement, getColumn() + displacement);
    }

    public Coordinate scaleBy(Coordinate factor) {
        return new Coordinate(getRow() * factor.getRow(), getColumn() * factor.getColumn());
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
        return "Coordinate(" + row + ", " + column + ")";
    }
}
