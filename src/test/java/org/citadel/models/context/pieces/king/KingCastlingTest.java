package org.citadel.models.context.pieces.king;

import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.context.pieces.king.stubs.BoardKingStub;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.CastlingSide;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.special.CastingMoveGenerator;
import org.citadel.models.support.Square;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class KingCastlingTest {

    private final String kingPosition;

    private final Player kingPlayer;

    private final boolean kingMoved;

    private final CastlingSide side;

    private final Coordinate expectedTargetCoordinate;

    private final boolean expectedResult;

    private final BoardKingStub boardObserver;

    @Parameterized.Parameters(name = "{index}: King at {0} ({1}), Side {3}, Expected: {5}")
    public static Collection<Object[]> cases() {
        List<Object[]> testCases = new ArrayList<>();

        // Helper to create a TestBoardObserver with default clean state
        BoardKingStub defaultObserver = new BoardKingStub();
        defaultObserver
            .setRookAvailableForCastling(1, 1, true) // White Long Rook
            .setRookAvailableForCastling(1, 8, true) // White Short Rook
            .setRookAvailableForCastling(8, 1, true) // Black Long Rook
            .setRookAvailableForCastling(8, 8, true); // Black Short Rook

        // --- Valid Castling Scenarios ---
        // White King, Short Castling, all conditions met
        testCases.add(new Object[]{"E1", Player.WHITE, false, CastlingSide.SHORT, new Coordinate(1, 7), true,
                new BoardKingStub()
                        .setKingInCheck(false)
                        .setOccupied(1,6, false) // F1 empty
                        .setOccupied(1,7, false) // G1 empty
                        .setRookAvailableForCastling(1,8, true)
                        .setSquareAttackedBy(1,6, false) // F1 not attacked
                        .setSquareAttackedBy(1,7, false) // G1 not attacked
        });
        // White King, Long Castling, all conditions met
        testCases.add(new Object[]{"E1", Player.WHITE, false, CastlingSide.LONG, new Coordinate(1, 3), true,
                new BoardKingStub()
                        .setKingInCheck(false)
                        .setOccupied(1,2, false) // B1 empty
                        .setOccupied(1,3, false) // C1 empty
                        .setOccupied(1,4, false) // D1 empty
                        .setRookAvailableForCastling(1,1, true)
                        .setSquareAttackedBy(1,2, false) // B1 not attacked
                        .setSquareAttackedBy(1,3, false) // C1 not attacked
                        .setSquareAttackedBy(1,4, false) // D1 not attacked
        });
        // Black King, Short Castling, all conditions met
        testCases.add(new Object[]{"E8", Player.BLACK, false, CastlingSide.SHORT, new Coordinate(8, 7), true,
                new BoardKingStub()
                        .setKingInCheck(false)
                        .setOccupied(8,6, false) // F8 empty
                        .setOccupied(8,7, false) // G8 empty
                        .setRookAvailableForCastling(8,8, true)
                        .setSquareAttackedBy(8,6, false) // F8 not attacked
                        .setSquareAttackedBy(8,7, false) // G8 not attacked
        });
        // Black King, Long Castling, all conditions met
        testCases.add(new Object[]{"E8", Player.BLACK, false, CastlingSide.LONG, new Coordinate(8, 3), true,
                new BoardKingStub()
                        .setKingInCheck(false)
                        .setOccupied(8,2, false) // B8 empty
                        .setOccupied(8,3, false) // C8 empty
                        .setOccupied(8,4, false) // D8 empty
                        .setRookAvailableForCastling(8,1, true)
                        .setSquareAttackedBy(8,2, false) // B8 not attacked
                        .setSquareAttackedBy(8,3, false) // C8 not attacked
                        .setSquareAttackedBy(8,4, false) // D8 not attacked
        });

        // --- Invalid Castling Scenarios ---

        // King has moved
        testCases.add(new Object[]{"E1", Player.WHITE, true, CastlingSide.SHORT, null, false, defaultObserver});
        testCases.add(new Object[]{"E1", Player.WHITE, true, CastlingSide.LONG, null, false, defaultObserver});

        // Rook has moved
        testCases.add(new Object[]{"E1", Player.WHITE, false, CastlingSide.SHORT, null, false,
                new BoardKingStub().setRookAvailableForCastling(1,8, false)
        });
        testCases.add(new Object[]{"E1", Player.WHITE, false, CastlingSide.LONG, null, false,
                new BoardKingStub().setRookAvailableForCastling(1,1, false)
        });

        // King is in check
        testCases.add(new Object[]{"E1", Player.WHITE, false, CastlingSide.SHORT, null, false,
                new BoardKingStub().setKingInCheck(true)
        });

        // Squares between King and Rook are occupied
        testCases.add(new Object[]{"E1", Player.WHITE, false, CastlingSide.SHORT, null, false,
                new BoardKingStub()
                        .setKingInCheck(false)
                        .setOccupied(1,6, true) // F1 occupied
                        .setRookAvailableForCastling(1,8, true)
                        .setSquareAttackedBy(1,6, false)
                        .setSquareAttackedBy(1,7, false)
        });

        // Square king passes through is attacked
        testCases.add(new Object[]{"E1", Player.WHITE, false, CastlingSide.SHORT, null, false,
                new BoardKingStub()
                        .setKingInCheck(false)
                        .setOccupied(1,6, false)
                        .setOccupied(1,7, false)
                        .setRookAvailableForCastling(1,8, true)
                        .setSquareAttackedBy(1,6, true) // F1 attacked
                        .setSquareAttackedBy(1,7, false)
        });

        // Square king lands on is attacked
        testCases.add(new Object[]{"E1", Player.WHITE, false, CastlingSide.SHORT, null, false,
                new BoardKingStub()
                        .setKingInCheck(false)
                        .setOccupied(1,6, false)
                        .setOccupied(1,7, false)
                        .setRookAvailableForCastling(1,8, true)
                        .setSquareAttackedBy(1,6, false)
                        .setSquareAttackedBy(1,7, true) // G1 attacked
        });

        return testCases;
    }

    public KingCastlingTest(String kingPosition, Player kingPlayer, boolean kingMoved, CastlingSide side, Coordinate expectedTargetCoordinate, boolean expectedResult, BoardKingStub boardObserver) {
        this.kingPosition = kingPosition;
        this.kingPlayer = kingPlayer;
        this.kingMoved = kingMoved;
        this.side = side;
        this.expectedTargetCoordinate = expectedTargetCoordinate;
        this.expectedResult = expectedResult;
        this.boardObserver = boardObserver;
    }

    @Test
    public void testCastlingAvailability() {
        King king = new King(Square.from(kingPosition).toCoordinate(), kingPlayer);
        // Simulate king moved state
        if (kingMoved) {
            king.put(Square.from(kingPosition).toCoordinate()); // This will set isMoved=true
        }
        king.subscribe(boardObserver); // Inject the test observer

        // Use CastingMoveGenerator to test the overall logic
        CastingMoveGenerator generator = CastingMoveGenerator.getInstance();
        List<Coordinate> moves = generator.generator(king);

        if (expectedResult) {
            assertTrue("Castling should be available for " + kingPlayer + " " + side, !moves.isEmpty());
            assertEquals("Incorrect castling target for " + kingPlayer + " " + side, expectedTargetCoordinate, moves.get(0));
        } else {
            assertFalse("Castling should not be available for " + kingPlayer + " " + side, !moves.isEmpty());
        }
    }
}
