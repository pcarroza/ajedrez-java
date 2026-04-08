package org.citadel.models.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.citadel.models.context.pieces.knight.stubs.BoardStub;
import org.citadel.models.modules.game.Board;
import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.enums.Player;

public class BishopDsl {

    private String position;

    private Player player;

    private Bishop bishop;

    private BoardObserver board;

    public static BishopDsl aBishop() {
        return new BishopDsl();
    }

    public BishopDsl withAnEmptyBoard() {
        board = new BoardStub();
        return this;
    }

    public BishopDsl withAstartingBoard() {
        board = new Board();
        return this;
    }

    public BishopDsl at(String position) {
        this.position = position;
        return this;
    }

    public BishopDsl as(Player player) {
        this.player = player;
        return this;
    }

    private List<String> movements() {
        Bishop bishop = buildBishop();
        return bishop.getMovements().stream().map(it -> Square.from(it).toString()).toList();
    }

    private Bishop buildBishop() {
        Coordinate coordinate = Square.from(position).toCoordinate();
        bishop = new Bishop(coordinate, player);
        bishop.subscribe(board);
        bishop.generateMovements();
        return bishop;
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
