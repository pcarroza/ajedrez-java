package org.citadel.models.context.pieces.knight.extremevalues;

import static org.citadel.models.modules.game.pieces.enums.Player.BLACK;
import static org.citadel.models.modules.game.pieces.enums.Player.WHITE;
import static org.citadel.models.support.BoardDsl.aBoardAtStartingPosition;

import java.util.Arrays;
import java.util.Collection;

import org.citadel.models.modules.game.pieces.enums.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class KnightInitialPositionMovesTest {

    private final String square;

    private final Player turn;

    private final String[] reachable;

    private final String[] blocked;

    public KnightInitialPositionMovesTest(String square, Player turn, String[] reachable, String[] blocked) {
        this.square = square;
        this.turn = turn;
        this.reachable = reachable;
        this.blocked = blocked;
    }

    @Parameterized.Parameters(name = "Knight {1} at {0}")
    public static Collection<Object[]> cases() {
        return Arrays.asList(new Object[][] {
                {
                        "B1", WHITE,
                        new String[] { "A3", "C3" },
                        new String[] { "A2", "C2" }
                },
                {
                        "G1", WHITE,
                        new String[] { "F3", "H3" },
                        new String[] { "F2", "H2" }
                },
                {
                        "B8", BLACK,
                        new String[] { "A6", "C6" },
                        new String[] { "A7", "C7" }
                },
                {
                        "G8", BLACK,
                        new String[] { "F6", "H6" },
                        new String[] { "F7", "H7" }
                }
        });
    }

    @Test
    public void givenKnightAtInitialPosition_thenValidMovesAreReachable() {
        aBoardAtStartingPosition()
                .withTurn(turn)
                .selectKinghtAt(square)
                .shouldReach(reachable);
    }

    @Test
    public void givenKnightAtInitialPosition_thenPawnSquaresAreBlocked() {
        aBoardAtStartingPosition()
                .withTurn(turn)
                .selectKinghtAt(square)
                .shouldNotReach(blocked);
    }
}