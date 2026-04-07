package org.citadel.models.context.pieces.knight.extremevalues;

import org.citadel.models.modules.game.pieces.enums.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.citadel.models.modules.game.pieces.enums.Player.BLACK;
import static org.citadel.models.modules.game.pieces.enums.Player.WHITE;
import static org.citadel.models.support.KnightDsl.aKnight;

@RunWith(Parameterized.class)
public class KnightCenterMovesTest {

    private final String square;

    private final Player player;

    private final List<String> expectedSquares;

    public KnightCenterMovesTest(String square, Player player, List<String> expectedSquares) {
        this.square = square;
        this.player = player;
        this.expectedSquares = expectedSquares;
    }

    @Parameterized.Parameters(name = "Knight at {0} as {1}")
    public static Collection<Object[]> cases() {
        return Arrays.asList(new Object[][] {
                { "D4", WHITE, List.of("C2", "E2", "B3", "F3", "B5", "F5", "C6", "E6") },
                { "E5", BLACK, List.of("D3", "F3", "C4", "G4", "C6", "G6", "D7", "F7") }
        });
    }

    @Test
    public void givenKnightAtCenter_thenEightMovements() {
        aKnight()
                .withAnEmptyBoard()
                .at(square)
                .as(player)
                .shouldReachOnly(expectedSquares);
    }
}