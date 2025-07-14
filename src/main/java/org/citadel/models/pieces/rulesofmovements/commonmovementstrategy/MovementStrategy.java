package org.citadel.models.pieces.rulesofmovements.commonmovementstrategy;

import org.citadel.models.pieces.rulesofmovements.commonmovementstrategy.utils.ControlFlag;
import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class MovementStrategy {

    protected static final int INCREASE = 1;

    protected Piece piece;

    private final ControlFlag controlFlag;

    protected MovementStrategy(Piece piece) {
        assert piece != null;
        this.piece = piece;
        controlFlag = new ControlFlag();
    }

    protected abstract Stream<Coordinate> generate();

    protected Stream<Coordinate> generate(Coordinate vector) {
        assert vector != null;
        List<Coordinate> coordinates = new ArrayList<>();
        final int step = 1;
        generateRecursive(coordinates, vector, step);
        controlFlag.reset();
        return coordinates.stream();
    }

    private void generateRecursive(List<Coordinate> coordinates, Coordinate vector, int step) {
        if (!isWithinBoardLimits(step) || !controlFlag.shouldContinue()) {
            return;
        }
        Coordinate coordinate = getDisplacedCoordinateBy(step, vector);
        if (isPossibleMove(coordinate)) {
            coordinates.add(coordinate);
        }
        generateRecursive(coordinates, vector, step + INCREASE);
    }

    protected abstract Coordinate getDisplacedCoordinateBy(int step, Coordinate vector);

    private boolean isWithinBoardLimits(int step) {
        assert step >= 1;
        Coordinate desplacedCoordinate = piece.getDisplacedCoordinateBy(step);
        return ValidatorLimitsBoard.getInstance().isWithinLimits(desplacedCoordinate);
    }

    private boolean isPossibleMove(Coordinate coordinate) {
        assert coordinate != null;
        if (piece.isItEnemy(coordinate)) {
            controlFlag.stop();
            return true;
        }
        if (piece.sameColor(coordinate)) {
            controlFlag.stop();
            return false;
        }
        return true;
    }
}
