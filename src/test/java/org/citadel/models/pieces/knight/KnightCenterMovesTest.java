package org.citadel.models.pieces.knight;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.pieces.knight.stubs.BoardStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class KnightCenterMovesTest {

    private final Coordinate origin;

    private final Player player;

    private final List<Coordinate> expectedMoves;

    public KnightCenterMovesTest(Coordinate origin, Player player, List<Coordinate> expectedMoves) {
        this.origin = origin;
        this.player = player;
        this.expectedMoves = expectedMoves;
    }

    @Parameterized.Parameters(name = "Knight at {0} as {1}")
    public static Collection<Object[]> cases() {
        return Arrays.asList(new Object[][] {
                {
                        new Coordinate(4, 4), Player.WHITE,
                        List.of(
                                new Coordinate(6, 3), new Coordinate(6, 5),
                                new Coordinate(5, 6), new Coordinate(3, 6),
                                new Coordinate(2, 5), new Coordinate(2, 3),
                                new Coordinate(3, 2), new Coordinate(5, 2))
                },
                {
                        new Coordinate(5, 5), Player.BLACK,
                        List.of(
                                new Coordinate(7, 4), new Coordinate(7, 6),
                                new Coordinate(6, 7), new Coordinate(4, 7),
                                new Coordinate(3, 6), new Coordinate(3, 4),
                                new Coordinate(4, 3), new Coordinate(6, 3))
                }
        });
    }

    @Test
    public void givenKnightAtCenter_thenEightMovements() {
        List<Coordinate> movements = getMovements(origin, player);
        expectedMoves.forEach(expected -> assertTrue(movements.contains(expected)));
    }

    private List<Coordinate> getMovements(Coordinate coordinate, Player player) {
        Knight knight = new Knight(coordinate, player);
        knight.subscribe(new BoardStub());
        knight.generateMovements();
        return knight.getMovements();
    }
}