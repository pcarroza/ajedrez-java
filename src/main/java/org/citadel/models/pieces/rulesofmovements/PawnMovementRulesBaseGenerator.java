package org.citadel.models.pieces.rulesofmovements;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.Player;
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
        Player player = getPlayer();
        assert player != Player.NONE;
        possibleMoves = new ArrayList<>();
        possibleMoves.addAll(calculateForwardMoves(player));
        possibleMoves.addAll(calculateDiagonalCaptureMoves(player));
        possibleMoves.removeIf(it -> !ValidatorLimitsBoard.getInstance().isWithinLimits(it));
    }

    private List<Coordinate> calculateForwardMoves(Player player) {
        Coordinate coordinateFirstBox = pawn.getDisplacedBy(new Coordinate(player.getPlayer()));
        if (pawn.isSquareEmpty(coordinateFirstBox)) {
            return List.of();
        }
        final int singleStep = 1;
        final int doubleStep = 2;
        int maximumAdvance = pawn.isInitialState() ? doubleStep : singleStep;
        if (maximumAdvance == singleStep) {
            return List.of(coordinateFirstBox);
        }
        Coordinate coordinateSecondBox = pawn.getDisplacedBy(new Coordinate(doubleStep * player.getPlayer()));
        if (pawn.isSquareEmpty(coordinateSecondBox)) {
            return List.of(coordinateFirstBox);
        }
        return List.of(coordinateFirstBox, coordinateSecondBox);
    }

    private List<Coordinate> calculateDiagonalCaptureMoves(Player player) {
        final int leftDiagonalOffset = -1;
        final int rightDiagonalOffset = 1;
        return Stream.of(leftDiagonalOffset, rightDiagonalOffset)
                .map(offset -> pawn.getDisplacedBy(new Coordinate(player.getPlayer(), offset)))
                .filter(pawn::isItEnemy)
                .toList();
    }

    private Player getPlayer() {
        if (pawn.isWhite()) {
            return Player.WHITE;
        }
        if (pawn.isBlack()) {
            return Player.BLACK;
        }
        return Player.NONE;
    }
}