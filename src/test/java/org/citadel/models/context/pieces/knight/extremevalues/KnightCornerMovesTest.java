package org.citadel.models.context.pieces.knight.extremevalues;

import org.citadel.models.modules.game.pieces.enums.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.citadel.models.support.KnightDsl.aKnight;

@RunWith(Parameterized.class)
public class KnightCornerMovesTest {

    private final String square;

    private final Player player;

    private final List<String> expectedMoves;

    public KnightCornerMovesTest(String square, Player player, List<String> expectedMoves) {
        this.square = square;
        this.player = player;
        this.expectedMoves = expectedMoves;
    }

    @Parameterized.Parameters(name = "Knight at {0} as {1}")
    public static Collection<Object[]> cases() {
        return Arrays.asList(new Object[][] {
                { "A1", Player.WHITE, List.of("B3", "C2") },
                { "H1", Player.WHITE, List.of("G3", "F2") },
                { "A8", Player.BLACK, List.of("B6", "C7") },
                { "H8", Player.BLACK, List.of("G6", "F7") }
        });
    }

    @Test
    public void givenKnightAtCorner_thenExactlyTwoMovements() {
        aKnight()
                .withAnEmptyBoard()
                .at(square)
                .as(player)
                .shouldReachOnly(expectedMoves);
    }
}