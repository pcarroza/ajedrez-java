package org.citadel.models.pieces.rulesofmovements.commonmovementstrategy;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.stream.Stream;

public class DiagonalMovementStrategy extends MovementStrategy {

    public DiagonalMovementStrategy(Piece piece) {
        super(piece);
    }

    @Override
    public Stream<Coordinate> generate() {
        Stream<Coordinate> upRightCoordinates = generate(new Coordinate(1, 1));
        Stream<Coordinate> downRightCoordinates = generate(new Coordinate(-1, -1));
        return Stream.concat(upRightCoordinates, downRightCoordinates);
    }

    @Override
    protected Coordinate getDisplacedCoordinateBy(int step, Coordinate vector) {
        assert vector != null;
        assert step >= 1;
        return piece.getDisplacedCoordinateBy(new Coordinate(step, step), vector);
    }
}
