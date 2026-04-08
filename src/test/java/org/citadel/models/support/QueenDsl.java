package org.citadel.models.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.citadel.models.context.pieces.knight.stubs.BoardStub;
import org.citadel.models.modules.game.Board;
import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.enums.Player;

public class QueenDsl {

    private String position;

    private Player player;

    private Queen queen;

    private BoardObserver board;

    public static QueenDsl aQueen() {
        return new QueenDsl();
    }

    public QueenDsl withAnEmptyBoard() {
        board = new BoardStub();
        return this;
    }

    public QueenDsl withAstartingBoard() {
        board = new Board();
        return this;
    }

    public QueenDsl at(String position) {
        this.position = position;
        return this;
    }

    public QueenDsl as(Player player) {
        this.player = player;
        return this;
    }

    private List<String> movements() {
        Queen queen = buildQueen();
        return queen.getMovements().stream().map(it -> Square.from(it).toString()).toList();
    }

    private Queen buildQueen() {
        Coordinate coordinate = Square.from(position).toCoordinate();
        queen = new Queen(coordinate, player);
        queen.subscribe(board);
        queen.generateMovements();
        return queen;
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
