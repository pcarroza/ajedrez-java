package org.citadel.models.pieces.knight;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.citadel.models.modules.game.Board;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.junit.Test;

public class KnightMovesCountTest {

    private static final int EXPECTED_KNIGHT_INITIAL_MOVES = 2;

    private static final int WHITE_ROW = 1;

    private static final int BLACK_ROW = 8;

    private static final int LEFT_KNIGHT_COLUMN = 2;

    private static final int RIGHT_KNIGHT_COLUMN = 7;

    @Test
    public void givenWhiteKnightAtInitialPosition_1_2_thenHasTwoMoves() {
        List<Coordinate> moves = getMoves(WHITE_ROW, LEFT_KNIGHT_COLUMN, Player.WHITE);
        assertEquals(EXPECTED_KNIGHT_INITIAL_MOVES, moves.size());
    }

    @Test
    public void givenWhiteKnightAtInitialPosition_1_7_thenHasTwoMoves() {
        List<Coordinate> moves = getMoves(WHITE_ROW, RIGHT_KNIGHT_COLUMN, Player.WHITE);
        assertEquals(EXPECTED_KNIGHT_INITIAL_MOVES, moves.size());
    }

    @Test
    public void givenBlackKnightAtInitialPosition_8_2_thenHasTwoMoves() {
        List<Coordinate> moves = getMoves(BLACK_ROW, LEFT_KNIGHT_COLUMN, Player.BLACK);
        assertEquals(EXPECTED_KNIGHT_INITIAL_MOVES, moves.size());
    }

    @Test
    public void givenBlackKnightAtInitialPosition_8_7_thenHasTwoMoves() {
        List<Coordinate> moves = getMoves(BLACK_ROW, RIGHT_KNIGHT_COLUMN, Player.BLACK);
        assertEquals(EXPECTED_KNIGHT_INITIAL_MOVES, moves.size());
    }

    private List<Coordinate> getMoves(int row, int col, Player player) {
        Board board = new Board();
        if (player == Player.WHITE) {
            board.switchTurn();
        }
        board.selectPiece(new Coordinate(row, col));
        return board.getSelectedPieceMovements();
    }
}