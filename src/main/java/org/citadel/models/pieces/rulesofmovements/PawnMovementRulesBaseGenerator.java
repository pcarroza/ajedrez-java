package org.citadel.models.pieces.rulesofmovements;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Color;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Pawn;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PawnMovementRulesBaseGenerator extends MovementRulesBaseGenerator {

    private Pawn pawn;

    public PawnMovementRulesBaseGenerator(Piece piece) {
        set(piece);
    }

    @Override
    public void set(Piece piece) {
        pawn = (Pawn) piece;
    }

    @Override
    public void generate() {
        Color color = getColor();
        assert color != Color.NONE;
        possibleMoves = new ArrayList<>();
        possibleMoves.addAll(calculateForwardMoves(color));
        possibleMoves.addAll(calculateDiagonalCaptureMoves(color));
        possibleMoves.removeIf(it -> !ValidatorLimitsBoard.getInstance().isWithinLimits(it));
    }

    private List<Coordinate> calculateForwardMoves(Color color) {
        final int singleStep = 1;
        final int doubleStep = 2;
        int maximumAdvance = pawn.isInitialState() ? doubleStep : singleStep;
        Coordinate coordinateFirstBox = pawn.getDisplacedBy(new Coordinate(color.getDirection()));
        if (pawn.isBoxOccupied(coordinateFirstBox)) {
            return List.of();
        }
        if (maximumAdvance == singleStep) {
            return List.of(coordinateFirstBox);
        }
        Coordinate coordinateSecondBox = pawn.getDisplacedBy(new Coordinate(doubleStep * color.getDirection()));
        if (pawn.isBoxOccupied(coordinateSecondBox)) {
            return List.of(coordinateFirstBox);
        }
        return List.of(coordinateFirstBox, coordinateSecondBox);
    }

    private List<Coordinate> calculateDiagonalCaptureMoves(Color color) {
        final int leftDiagonalOffset = -1;
        final int rightDiagonalOffset = 1;
        return Stream.of(leftDiagonalOffset, rightDiagonalOffset)
                .map(offset -> pawn.getDisplacedBy(new Coordinate(color.getDirection(), offset)))
                .filter(pawn::isItEnemy)
                .toList();
    }

    private Color getColor() {
        if (pawn.isWhite()) {
            return Color.WHITE;
        }
        if (pawn.isBlack()) {
            return Color.BLACK;
        }
        return Color.NONE;
    }
}