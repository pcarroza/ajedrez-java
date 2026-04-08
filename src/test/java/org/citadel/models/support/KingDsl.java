package org.citadel.models.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.citadel.models.context.pieces.knight.stubs.BoardStub;
import org.citadel.models.modules.game.Board;
import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.enums.Player;

public class KingDsl {

    private String position;

    private Player player;

    private King king;

    private BoardObserver board;

    public static KingDsl aKing() {
        return new KingDsl();
    }

    public KingDsl withAnEmptyBoard() {
        board = new BoardStub();
        return this;
    }

    public KingDsl withAstartingBoard() {
        board = new Board();
        return this;
    }

    public KingDsl at(String position) {
        this.position = position;
        return this;
    }

    public KingDsl as(Player player) {
        this.player = player;
        return this;
    }

    private List<String> movements() {
        King king = buildKing();
        return king.getMovements().stream().map(it -> Square.from(it).toString()).toList();
    }

    private King buildKing() {
        Coordinate coordinate = Square.from(position).toCoordinate();
        king = new King(coordinate, player);
        king.subscribe(board);
        king.generateMovements();
        return king;
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
