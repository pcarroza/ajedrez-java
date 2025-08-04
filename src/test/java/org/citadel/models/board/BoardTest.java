package org.citadel.models.board;

import org.citadel.models.Board;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

import org.citadel.models.pieces.Coordinate;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void selectPiece() {
        assertFalse(board.isBoxEmpty(new Coordinate()));
    }

    @Test
    public void putSelectedPieceInThis() {
    }

    @Test
    public void removeCurrentPlayerColorPiece() {
    }

    @Test
    public void removeRivalPlayerPiece() {
    }

    @Test
    public void isPieceEndBoard() {
    }

    @Test
    public void currentPlayerColor() {
    }

    @Test
    public void rivalPlayer() {
    }

    @Test
    public void changeTurn() {
    }

    @Test
    public void isPieceSelected() {
    }

    @Test
    public void isTheWhitePieceSelected() {
    }

    @Test
    public void isTheBlackPieceSelected() {
    }

    @Test
    public void isBoxEmpty() {
    }

    @Test
    public void isMovementValid() {
    }

    @Test
    public void inDiagonal() {
    }

    @Test
    public void inInverse() {
    }

    @Test
    public void inHorizontal() {
    }

    @Test
    public void inVertical() {
    }

    @Test
    public void finished() {
    }
}