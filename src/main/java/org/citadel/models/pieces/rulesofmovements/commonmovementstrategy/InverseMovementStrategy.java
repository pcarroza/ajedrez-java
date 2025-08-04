package org.citadel.models.pieces.rulesofmovements.commonmovementstrategy;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.stream.Stream;

public class InverseMovementStrategy extends MovementStrategy {

    public InverseMovementStrategy(Piece piece) {
        super(piece);
    }

    @Override
    public Stream<Coordinate> generate() {
        Stream<Coordinate> upLeftCoordinates = generate(new Coordinate(1, -1));
        Stream<Coordinate> downRightCoordinates = generate(new Coordinate(-1, 1));
        return Stream.concat(upLeftCoordinates, downRightCoordinates);
    }

    @Override
    public Coordinate getDisplacedCoordinateBy(int step, Coordinate vector) {
        assert vector != null;
        assert step >= 1;
        return piece.getDisplacedBy(new Coordinate(step, step), vector);
    }
}
