package org.citadel.models.context.pieces.knight.extremevalues;

import static org.citadel.models.modules.game.pieces.enums.Player.BLACK;
import static org.citadel.models.modules.game.pieces.enums.Player.WHITE;
import static org.citadel.models.support.BoardDsl.aBoardAtStartingPosition;

import org.citadel.models.modules.game.pieces.enums.Player;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class KnightMovesCountTest {

    private static final int EXPECTED_MOVES_AT_START = 2;

    private final String square;

    private final Player turn;

    public KnightMovesCountTest(String square, Player turn) {
        this.square = square;
        this.turn = turn;
    }

    @Parameterized.Parameters(name = "{index}: Knight at {0} as {1}")
    public static Collection<Object[]> cases() {
        return Arrays.asList(new Object[][] {
                { "B1", WHITE },
                { "G1", WHITE },
                { "B8", BLACK },
                { "G8", BLACK }
        });
    }

    @Test
    public void givenKnightAtInitialPosition_thenExactlyTwoMovesAvailable() {
        aBoardAtStartingPosition()
                .withTurn(turn)
                .selectKinghtAt(square)
                .shouldReachExactly(EXPECTED_MOVES_AT_START);
    }
}