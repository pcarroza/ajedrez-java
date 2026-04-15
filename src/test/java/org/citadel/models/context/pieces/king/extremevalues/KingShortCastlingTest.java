package org.citadel.models.context.pieces.king.extremevalues;

import org.citadel.models.context.pieces.king.support.KingDsl;
import org.citadel.models.context.pieces.king.support.builders.BoardKingStubBuilder;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.citadel.models.modules.game.pieces.enums.Player.BLACK;
import static org.citadel.models.modules.game.pieces.enums.Player.WHITE;
import static org.citadel.models.context.pieces.king.support.KingDsl.aKing;

@RunWith(Parameterized.class)
public class KingShortCastlingTest {

    private final String kingSquare;

    private final Player player;

    private final String rookSquare;

    private final String transit1;

    private final String transit2;

    private final String expectedTarget;

    public KingShortCastlingTest(
            String kingSquare,
            Player player,
            String rookSquare,
            String transit1,
            String transit2,
            String expectedTarget) {
        this.kingSquare = kingSquare;
        this.player = player;
        this.rookSquare = rookSquare;
        this.transit1 = transit1;
        this.transit2 = transit2;
        this.expectedTarget = expectedTarget;
    }

    @Parameterized.Parameters(name = "{1} king at {0} → short castling to {5}")
    public static Collection<Object[]> cases() {
        return Arrays.asList(new Object[][] {
                { "E1", WHITE, "H1", "F1", "G1", "G1" },
                { "E8", BLACK, "H8", "F8", "G8", "G8" },
        });
    }

    @Test
    public void givenAllConditionsMet_thenShortCastlingIsAvailable() {
        aKing()
                .at(kingSquare)
                .as(player)
                .fresh()
                .withBoard(BoardKingStubBuilder.aBoard()
                        .withKingNotInCheck()
                        .withRookAt(rookSquare)
                        .withEmptySquare(transit1)
                        .withEmptySquare(transit2)
                        .withSafeSquare(transit1)
                        .withSafeSquare(transit2))
                .canCastleTo(expectedTarget);
    }
}