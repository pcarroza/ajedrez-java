package org.citadel.models.context.pieces.knight.extremevalues;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.*;

import static org.citadel.models.modules.game.pieces.enums.Player.BLACK;
import static org.citadel.models.modules.game.pieces.enums.Player.WHITE;
import static org.citadel.models.support.KnightDsl.aKnight;
import org.citadel.models.modules.game.pieces.enums.Player;

@RunWith(Parameterized.class)
public class KnightEdgeMovesTest {

    private final String position;

    private final Player player;

    private final List<String> expectedMoves;

    public KnightEdgeMovesTest(String position, Player player, List<String> expectedMoves) {
        this.position = position;
        this.player = player;
        this.expectedMoves = expectedMoves;
    }

    @Parameterized.Parameters(name = "{index}: Knight at {0} as {1}")
    public static Collection<Object[]> cases() {
        return Arrays.asList(new Object[][] {
                { "A4", WHITE, List.of("B2", "B6", "C3", "C5") },
                { "D8", BLACK, List.of("F7", "B7", "E6", "C6") },
                { "B2", WHITE, List.of("D1", "D3", "A4", "C4") },
                { "G7", BLACK, List.of("E8", "H5", "F5", "E6") }
        });
    }

    @Test
    public void knight_edge_movement_is_correct() {
        aKnight()
                .withAnEmptyBoard()
                .at(position)
                .as(player)
                .shouldReachOnly(expectedMoves);
    }
}