package org.citadel.models.context.pieces.king.support;

import org.citadel.models.context.pieces.king.stubs.BoardKingStub;
import org.citadel.models.context.pieces.king.support.builders.BoardKingStubBuilder;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.special.CastingMoveGenerator;
import org.citadel.models.support.Square;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KingDsl {

    private String square;

    private Player player;

    private boolean hasMoved;

    public static KingDsl aKing() {
        return new KingDsl();
    }

    public KingDsl at(String square) {
        this.square = square;
        return this;
    }

    public KingDsl as(Player player) {
        this.player = player;
        return this;
    }

    public KingDsl fresh() {
        hasMoved = false;
        return this;
    }

    public KingDsl thatMoved() {
        hasMoved = true;
        return this;
    }

    public Assertions withBoard(BoardKingStub board) {
        return new Assertions(buildKing(board));
    }

    public Assertions withBoard(BoardKingStubBuilder builder) {
        return new Assertions(buildKing(builder.build()));
    }

    private King buildKing(BoardKingStub board) {
        Coordinate coordinate = Square.from(square).toCoordinate();
        King king = new King(coordinate, player);
        if (hasMoved) {
            king.put(coordinate);
        }
        king.subscribe(board);
        return king;
    }

    public static class Assertions {

        private final King king;

        Assertions(King king) {
            this.king = king;
        }

        public void canCastleTo(String expectedSquare) {
            List<Coordinate> moves = castlingMoves();
            Coordinate expected = Square.from(expectedSquare).toCoordinate();
            assertTrue("Castling should be available but no moves were generated", !moves.isEmpty());
            assertEquals("Castling target mismatch — expected " + expectedSquare, expected, moves.get(0));
        }

        public void cannotCastle() {
            List<Coordinate> moves = castlingMoves();
            assertTrue("Castling should be blocked but moves were generated: " + moves, moves.isEmpty());
        }

        private List<Coordinate> castlingMoves() {
            return CastingMoveGenerator.getInstance().generator(king);
        }
    }
}