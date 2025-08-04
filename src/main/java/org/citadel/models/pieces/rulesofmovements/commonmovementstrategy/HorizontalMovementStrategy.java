package org.citadel.models.pieces.rulesofmovements.commonmovementstrategy;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.stream.Stream;

public class HorizontalMovementStrategy extends MovementStrategy {

    public HorizontalMovementStrategy(Piece piece) {
        super(piece);
    }

    @Override
    public Stream<Coordinate> generate() {
        Stream<Coordinate> horizontalRightCoordinates = generate(new Coordinate(1, 1));
        Stream<Coordinate> horizontalLeftCoordinates = generate(new Coordinate(1, -1));
        return Stream.concat(horizontalRightCoordinates, horizontalLeftCoordinates);
    }

    @Override
    public Coordinate getDisplacedCoordinateBy(int step, Coordinate vector) {
        assert vector != null;
        assert step >= 1;
        return piece.getDisplacedBy(new Coordinate(0, step), vector);
    }
}
