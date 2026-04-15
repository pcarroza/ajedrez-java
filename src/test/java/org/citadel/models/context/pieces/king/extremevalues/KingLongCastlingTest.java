package org.citadel.models.context.pieces.king.extremevalues;

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
public class KingLongCastlingTest {

    private final String kingSquare;

    private final Player player;

    private final String rookSquare;

    private final String sq1;

    private final String sq2;

    private final String sq3;

    private final String expectedTarget;

    public KingLongCastlingTest(
            String kingSquare,
            Player player,
            String rookSquare,
            String sq1,
            String sq2,
            String sq3,
            String expectedTarget) {
        this.kingSquare = kingSquare;
        this.player = player;
        this.rookSquare = rookSquare;
        this.sq1 = sq1;
        this.sq2 = sq2;
        this.sq3 = sq3;
        this.expectedTarget = expectedTarget;
    }

    @Parameterized.Parameters(name = "{1} king at {0} → long castling to {6}")
    public static Collection<Object[]> cases() {
        return Arrays.asList(new Object[][] {
                { "E1", WHITE, "A1", "B1", "C1", "D1", "C1" },
                { "E8", BLACK, "A8", "B8", "C8", "D8", "C8" },
        });
    }

    @Test
    public void givenAllConditionsMet_thenLongCastlingIsAvailable() {
        aKing().at(kingSquare).as(player).fresh().withBoard(BoardKingStubBuilder.aBoard()
                .withKingNotInCheck()
                .withRookAt(rookSquare)
                .withEmptySquare(sq1)
                .withEmptySquare(sq2)
                .withEmptySquare(sq3)
                .withSafeSquare(sq1)
                .withSafeSquare(sq2)
                .withSafeSquare(sq3)).canCastleTo(expectedTarget);
    }
}