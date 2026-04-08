package org.citadel.models.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.citadel.models.context.pieces.knight.stubs.BoardStub;
import org.citadel.models.modules.game.Board;
import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Rook;
import org.citadel.models.modules.game.pieces.enums.Player;

public class RookDsl {

    private String position;

    private Player player;

    private Rook rook;

    private BoardObserver board;

    public static RookDsl aRook() {
        return new RookDsl();
    }

    public RookDsl withAnEmptyBoard() {
        board = new BoardStub();
        return this;
    }

    public RookDsl withAstartingBoard() {
        board = new Board();
        return this;
    }

    public RookDsl at(String position) {
        this.position = position;
        return this;
    }

    public RookDsl as(Player player) {
        this.player = player;
        return this;
    }

    private List<String> movements() {
        Rook rook = buildRook();
        return rook.getMovements().stream().map(it -> Square.from(it).toString()).toList();
    }

    private Rook buildRook() {
        Coordinate coordinate = Square.from(position).toCoordinate();
        rook = new Rook(coordinate, player);
        rook.subscribe(board);
        rook.generateMovements();
        return rook;
    }

    public void shouldReachOnly(List<String> expectedMoves) {
        List<String> actualMoves = movements();
        expectedMoves.forEach(move -> assertTrue("Missing move: " + move, actualMoves.contains(move)));
    }

    public void shouldReachExactly(int expectedCount) {
        List<String> actual = movements();
        assertEquals("Expected " + expectedCount + " moves but got " + actual.size() + ": " + actual,
                expectedCount,
                actual.size());
    }
}
