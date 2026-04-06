package org.citadel.models.support;

import org.citadel.models.context.pieces.knight.enums.File;
import org.citadel.models.modules.game.pieces.Coordinate;

public class Square {

    private File file;

    private int range;

    private Square(File file, int range) {
        assert range > 1 || range < 8 : "Rank must be between 1 and 8";
        this.file = file;
        this.range = range;
    }

    public static Square from(String square) {
        assert square != null : "Squard not is null";
        assert square.length() == 2 : "Invalid square: " + square;
        File file = File.from(square.charAt(0));
        int range = Character.getNumericValue(square.charAt(1));
        return new Square(file, range);
    }

    public static Square from(Coordinate coordinate) {
        assert coordinate != null : "Coordinate cannot be null";
        return new Square(File.from(coordinate.column()), coordinate.row());
    }

    public Coordinate toCoordinate() {
        return new Coordinate(range, file.column());
    }

    @Override
    public String toString() {
        return file.chatAt() + String.valueOf(range);
    }

    public static void main(String[] args) {
        System.out.println(Square.from("B1").toCoordinate());
    }
}