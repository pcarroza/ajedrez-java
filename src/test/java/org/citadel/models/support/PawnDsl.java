package org.citadel.models.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.citadel.models.context.pieces.knight.stubs.BoardStub;
import org.citadel.models.modules.game.Board;
import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.enums.Player;

public class PawnDsl {

    private String position;

    private Player player;

    private Pawn pawn;

    private BoardObserver board;

    public static PawnDsl aPawn() {
        return new PawnDsl();
    }

    public PawnDsl withAnEmptyBoard() {
        board = new BoardStub();
        return this;
    }

    public PawnDsl withAstartingBoard() {
        board = new Board();
        return this;
    }

    public PawnDsl at(String position) {
        this.position = position;
        return this;
    }

    public PawnDsl as(Player player) {
        this.player = player;
        return this;
    }

    private List<String> movements() {
        Pawn pawn = buildPawn();
        return pawn.getMovements().stream().map(it -> Square.from(it).toString()).toList();
    }

    private Pawn buildPawn() {
        Coordinate coordinate = Square.from(position).toCoordinate();
        pawn = new Pawn(coordinate, player);
        pawn.subscribe(board);
        pawn.generateMovements();
        return pawn;
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
