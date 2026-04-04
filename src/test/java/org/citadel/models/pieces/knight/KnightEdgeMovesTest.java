package org.citadel.models.pieces.knight;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.pieces.knight.stubs.BoardStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;
import java.util.stream.Collectors;

import static org.citadel.models.modules.game.pieces.enums.Player.BLACK;
import static org.citadel.models.modules.game.pieces.enums.Player.WHITE;
import static org.junit.Assert.assertTrue;

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
        aKnight().at(position).as(player).shouldReachOnly(expectedMoves);
    }

    // =========================
    // 🧠 ENTRY POINT DSL
    // =========================

    private KnightDsl aKnight() {
        return new KnightDsl();
    }

    // =========================
    // ⚔️ DSL COMPLETO
    // =========================

    private static class KnightDsl {

        private String position;

        private Player player;

        KnightDsl at(String position) {
            this.position = position;
            return this;
        }

        KnightDsl as(Player player) {
            this.player = player;
            return this;
        }

        void shouldReachOnly(List<String> expectedMoves) {
            List<String> actualMoves = movements();
            expectedMoves.forEach(move -> assertTrue("Missing move: " + move, actualMoves.contains(move)));
        }

        // =========================
        // ⚙️ Infra encapsulada
        // =========================

        private List<String> movements() {
            Knight knight = buildKnight();
            return knight.getMovements()
                    .stream()
                    .map(KnightEdgeMovesTest::toPosition)
                    .collect(Collectors.toList());
        }

        private Knight buildKnight() {
            Coordinate coordinate = toCoordinate(position);
            Knight knight = new Knight(coordinate, player);
            knight.subscribe(new BoardStub());
            knight.generateMovements();
            return knight;
        }
    }

    // =========================
    // 🔄 MAPPERS (aislados)
    // =========================

    private static Coordinate toCoordinate(String position) {
        int column = position.charAt(0) - 'A' + 1;
        int row = Character.getNumericValue(position.charAt(1));
        return new Coordinate(column, row);
    }

    private static String toPosition(Coordinate coordinate) {
        char column = (char) ('A' + coordinate.column() - 1);
        int row = coordinate.row();
        return "" + column + row;
    }
}