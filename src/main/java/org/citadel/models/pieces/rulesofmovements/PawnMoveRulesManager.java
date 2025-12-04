package org.citadel.models.pieces.rulesofmovements;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Color;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Pawn;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class PawnMoveRulesManager extends MoveRulesManager {

    private Pawn pawn;

    public PawnMoveRulesManager(Piece piece) {
        set(piece);
    }

    @Override
    public void set(Piece piece) {
        pawn = (Pawn) piece;
    }

    @Override
    public void buildMovements() {
        Color color = getColor();

        assert color != Color.NONE;

        possibleMoves = new ArrayList<>();
        possibleMoves.addAll(calculateForwardMoves(color));

        final int leftDiagonalOffset = -1;
        addCaptureMoveIfValid(new Coordinate(color.getDirection(), leftDiagonalOffset));

        final int rightDiagonalOffset = 1;
        addCaptureMoveIfValid(new Coordinate(color.getDirection(), rightDiagonalOffset));

        possibleMoves.removeIf(it -> !ValidatorLimitsBoard.getInstance().isWithinLimits(it));
    }

    private List<Coordinate> calculateForwardMoves(Color color) {
        final int singleStep = 1;
        final int doubleStep = 2;
        int maximumAdvance = pawn.isInitialState() ? doubleStep : singleStep;
        Coordinate coordinateFirstBox = pawn.getDisplacedCoordinateBy(new Coordinate(color.getDirection()));
        if (pawn.isBoxOccupied(coordinateFirstBox)) {
            return List.of();
        }
        if (maximumAdvance == singleStep) {
            return List.of(coordinateFirstBox);
        }
        Coordinate coordinateSecondBox = pawn.getDisplacedCoordinateBy(new Coordinate(doubleStep * color.getDirection()));
        if (pawn.isBoxOccupied(coordinateSecondBox)) {
            return List.of(coordinateFirstBox);
        }
        return List.of(coordinateFirstBox, coordinateSecondBox);
    }

    private void addCaptureMoveIfValid(Coordinate coordinate) {
        Coordinate capturePosition = pawn.getDisplacedCoordinateBy(coordinate);
        if (pawn.isItEnemy(capturePosition)) {
            possibleMoves.add(capturePosition);
        }
    }

    private Color getColor() {
        if (pawn.isWhite()) {
            return Color.WHITE;
        } else if (pawn.isBlack()) {
            return Color.BLACK;
        }
        return Color.NONE;
    }
}