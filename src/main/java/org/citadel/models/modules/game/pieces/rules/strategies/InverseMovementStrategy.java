package org.citadel.models.modules.game.pieces.rules.strategies;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

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
    public Coordinate getDisplacedCoordinateBy(int increment, Coordinate vector) {
        assert vector != null;
        assert increment >= 1;
        return piece.getDisplacedBy(new Coordinate(increment, increment), vector);
    }
}
