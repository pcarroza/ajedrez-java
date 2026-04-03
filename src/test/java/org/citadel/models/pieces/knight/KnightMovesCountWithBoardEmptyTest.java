package org.citadel.models.pieces.knight;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.pieces.knight.stubs.BoardStub;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightMovesCountWithBoardEmptyTest {

    @Test
    public void givenKnightAtCorner_1_1_thenTwoMoves() {
        assertEquals(2, countMoves(new Coordinate(1, 1), Player.WHITE));
    }

    @Test
    public void givenKnightAtCorner_8_1_thenTwoMoves() {
        assertEquals(2, countMoves(new Coordinate(8, 1), Player.WHITE));
    }

    @Test
    public void givenKnightAtCenter_4_4_thenEightMoves() {
        assertEquals(8, countMoves(new Coordinate(4, 4), Player.WHITE));
    }

    @Test
    public void givenKnightAtEdge_1_4_thenFourMoves() {
        assertEquals(4, countMoves(new Coordinate(1, 4), Player.WHITE));
    }

    @Test
    public void givenKnightAt_2_2_thenFourMoves() {
        assertEquals(4, countMoves(new Coordinate(2, 2), Player.WHITE));
    }

    @Test
    public void givenKnightAtCorner_1_8_thenTwoMoves() {
        assertEquals(2, countMoves(new Coordinate(1, 8), Player.BLACK));
    }

    @Test
    public void givenKnightAtCorner_8_8_thenTwoMoves() {
        assertEquals(2, countMoves(new Coordinate(8, 8), Player.BLACK));
    }

    @Test
    public void givenKnightAtCenter_5_5_thenEightMoves() {
        assertEquals(8, countMoves(new Coordinate(5, 5), Player.BLACK));
    }

    @Test
    public void givenKnightAtEdge_4_8_thenFourMoves() {
        assertEquals(4, countMoves(new Coordinate(4, 8), Player.BLACK));
    }

    @Test
    public void givenKnightAt_7_7_thenFourMoves() {
        assertEquals(4, countMoves(new Coordinate(7, 7), Player.BLACK));
    }

    private int countMoves(Coordinate coordinate, Player player) {
        Knight knight = new Knight(coordinate, player);
        knight.subscribe(new BoardStub());
        knight.generateMovements();
        return knight.getMovements().size();
    }
}