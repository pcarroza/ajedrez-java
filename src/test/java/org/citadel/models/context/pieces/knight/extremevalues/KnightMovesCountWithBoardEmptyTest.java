package org.citadel.models.context.pieces.knight.extremevalues;

import org.citadel.models.modules.game.pieces.enums.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.citadel.models.modules.game.pieces.enums.Player.BLACK;
import static org.citadel.models.modules.game.pieces.enums.Player.WHITE;
import static org.citadel.models.support.KnightDsl.aKnight;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class KnightMovesCountWithBoardEmptyTest {

    private final String square;

    private final Player player;

    private final int expectedCount;

    public KnightMovesCountWithBoardEmptyTest(String square, Player player, int expectedCount) {
        this.square = square;
        this.player = player;
        this.expectedCount = expectedCount;
    }

    @Parameterized.Parameters(name = "Knight at {0} as {1}")
    public static Collection<Object[]> cases() {
        return Arrays.asList(new Object[][] {
                // --- Corners (minimum: 2 moves) ---
                { "A1", WHITE, 2 },
                { "A8", WHITE, 2 },
                { "H1", BLACK, 2 },
                { "H8", BLACK, 2 },
                // --- Edges non-corner (4 moves) ---
                { "A4", WHITE, 4 },
                { "B2", WHITE, 4 },
                { "D8", BLACK, 4 },
                { "G7", BLACK, 4 },
                // --- Center (maximum: 8 moves) ---
                { "D4", WHITE, 8 },
                { "E5", BLACK, 8 },
        });
    }

    @Test
    public void givenKnightOnEmptyBoard_thenCorrectMoveCountIsGenerated() {
        aKnight()
                .withAnEmptyBoard()
                .at(square)
                .as(player)
                .shouldReachExactly(expectedCount);

    }
}