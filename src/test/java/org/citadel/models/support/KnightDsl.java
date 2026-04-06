package org.citadel.models.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.citadel.models.context.pieces.knight.stubs.BoardStub;
import org.citadel.models.modules.game.Board;
import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.enums.Player;

public class KnightDsl {

    private String position;

    private Player player;

    private Knight knight;

    private BoardObserver board;

    public static KnightDsl aKnight() {
        return new KnightDsl();
    }

    public KnightDsl withAnEmptyBoard() {
        board = new BoardStub();
        return this;
    }

    public KnightDsl withAstartingBoard() {
        board = new Board();
        return this;
    }

    public KnightDsl at(String position) {
        this.position = position;
        return this;
    }

    public KnightDsl as(Player player) {
        this.player = player;
        return this;
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

    private List<String> movements() {
        Knight knight = buildKnight();
        return knight.getMovements()
                .stream()
                .map(it -> Square.from(it).toString())
                .collect(Collectors.toList());
    }

    private Knight buildKnight() {
        Coordinate coordinate = Square.from(position).toCoordinate();
        knight = new Knight(coordinate, player);
        knight.subscribe(board);
        knight.generateMovements();
        return knight;
    }

}
