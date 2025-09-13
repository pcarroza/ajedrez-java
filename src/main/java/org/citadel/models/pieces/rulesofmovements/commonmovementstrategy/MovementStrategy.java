package org.citadel.models.pieces.rulesofmovements.commonmovementstrategy;

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
        generateRecursive(coordinates, vector, 1);
        return coordinates.stream();
    }

    private void generateRecursive(List<Coordinate> coordinates, Coordinate vector, int step) {
        Coordinate potentialCoordinate = getDisplacedCoordinateBy(step, vector);

        // --- Casos Base ---
        // 1. Si está fuera del tablero, detenemos la recursión.
        if (!ValidatorLimitsBoard.getInstance().isWithinLimits(potentialCoordinate)) {
            return;
        }

        // 2. Si es una pieza propia, bloquea el camino. Detenemos la recursión.
        if (piece.isPieceCurrentPlayer(potentialCoordinate)) {
            return;
        }

        // 3. Si es una pieza enemiga, es un movimiento de captura. La añadimos y detenemos la recursión.
        if (piece.isEnemy(potentialCoordinate)) {
            coordinates.add(potentialCoordinate);
            return;
        }

        // --- Paso Recursivo ---
        // Si la casilla está vacía, la añadimos y continuamos con el siguiente paso.
        coordinates.add(potentialCoordinate);
        generateRecursive(coordinates, vector, step + INCREASE);
    }

    protected abstract Coordinate getDisplacedCoordinateBy(int step, Coordinate vector);
}
