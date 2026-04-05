package org.citadel.models.pieces.knight;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.citadel.models.modules.game.Board;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.junit.Test;

public class KnightInitialPositionMovesTest {

    @Test
    public void whiteKnightInitialPositions_shouldHaveCorrectMoves() {
        assertValidMoves(
                new Coordinate(1, 2), Player.WHITE,
                new Coordinate(3, 1),
                new Coordinate(3, 3));

        assertValidMoves(
                new Coordinate(1, 7), Player.WHITE,
                new Coordinate(3, 6),
                new Coordinate(3, 8));
    }

    @Test
    public void whiteKnightInitialPositions_shouldNotHaveInvalidMoves() {
        assertInvalidMoves(
                new Coordinate(1, 2), Player.WHITE,
                new Coordinate(2, 1),
                new Coordinate(2, 4));

        assertInvalidMoves(
                new Coordinate(1, 7), Player.WHITE,
                new Coordinate(2, 6),
                new Coordinate(2, 8));
    }

    @Test
    public void blackKnightInitialPositions_shouldHaveCorrectMoves() {
        assertValidMoves(
                new Coordinate(8, 2), Player.BLACK,
                new Coordinate(6, 1),
                new Coordinate(6, 3));

        assertValidMoves(
                new Coordinate(8, 7), Player.BLACK,
                new Coordinate(6, 6),
                new Coordinate(6, 8));
    }

    @Test
    public void blackKnightInitialPositions_shouldNotHaveInvalidMoves() {
        assertInvalidMoves(
                new Coordinate(8, 2), Player.BLACK,
                new Coordinate(7, 1),
                new Coordinate(7, 3));

        assertInvalidMoves(
                new Coordinate(8, 7), Player.BLACK,
                new Coordinate(7, 6),
                new Coordinate(7, 8));
    }

    private void assertValidMoves(Coordinate origin, Player player, Coordinate... expected) {
        List<Coordinate> moves = getMoves(origin, player);
        Arrays.stream(expected).forEach(move -> assertTrue("Expected move not found: " + move, moves.contains(move)));
    }

    private void assertInvalidMoves(Coordinate origin, Player player, Coordinate... invalid) {
        List<Coordinate> moves = getMoves(origin, player);
        Arrays.stream(invalid).forEach(move -> assertFalse("Invalid move found: " + move, moves.contains(move)));
    }

    private List<Coordinate> getMoves(Coordinate coordinate, Player player) {
        Board board = new Board();
        if (player == Player.WHITE) {
            board.switchTurn();
        }
        board.selectPiece(coordinate);
        return board.getSelectedPieceMovements();
    }
}