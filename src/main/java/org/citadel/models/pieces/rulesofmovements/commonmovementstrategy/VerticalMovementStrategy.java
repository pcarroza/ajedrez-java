package org.citadel.models.pieces.rulesofmovements.commonmovementstrategy;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.stream.Stream;

public class VerticalMovementStrategy extends MovementStrategy {

    public VerticalMovementStrategy(Piece piece) {
        super(piece);
    }

    @Override
    public Stream<Coordinate> generate() {
        Stream<Coordinate> verticalUpCoordinates = generate(new Coordinate(1, 1));
        Stream<Coordinate> verticalDownCoordinates = generate(new Coordinate(-1, 1));
        return Stream.concat(verticalUpCoordinates, verticalDownCoordinates);
    }

    @Override
    public Coordinate getDisplacedCoordinateBy(int step, Coordinate vector) {
        assert vector != null;
        assert step >= 1;
        return piece.getDisplacedCoordinateBy(new Coordinate(step, 0), vector);
    }
}
