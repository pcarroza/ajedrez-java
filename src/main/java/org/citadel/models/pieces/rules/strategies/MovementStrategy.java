package org.citadel.models.pieces.rules.strategies;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class MovementStrategy {

    protected static final int INCREASE = 1;

    protected Piece piece;

    protected MovementStrategy(Piece piece) {
        assert piece != null;
        this.piece = piece;
    }

    protected abstract Stream<Coordinate> generate();

    protected Stream<Coordinate> generate(Coordinate vector) {
        assert vector != null;
        List<Coordinate> coordinates = new ArrayList<>();
        generateCoordinateRecursive(coordinates, vector, 1);
        return coordinates.stream();
    }

    private void generateCoordinateRecursive(List<Coordinate> coordinates, Coordinate vector, int step) {
        Coordinate coordinate = getDisplacedCoordinateBy(step, vector);
        if (!ValidatorLimitsBoard.getInstance().isWithinLimits(coordinate)) {
            return;
        }
        if (piece.isSameColorPieceAt(coordinate)) {
            return;
        }
        if (piece.isEnemy(coordinate)) {
            coordinates.add(coordinate);
            return;
        }
        coordinates.add(coordinate);
        generateCoordinateRecursive(coordinates, vector, step + INCREASE);
    }

    protected abstract Coordinate getDisplacedCoordinateBy(int increment, Coordinate vector);
}
