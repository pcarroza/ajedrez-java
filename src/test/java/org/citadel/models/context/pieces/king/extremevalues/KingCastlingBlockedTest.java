package org.citadel.models.context.pieces.king.extremevalues;

import org.citadel.models.context.pieces.king.support.builders.BoardKingStubBuilder;
import org.junit.Test;

import static org.citadel.models.modules.game.pieces.enums.Player.WHITE;
import static org.citadel.models.context.pieces.king.support.KingDsl.aKing;

public class KingCastlingBlockedTest {

    @Test
    public void givenKingHasMoved_thenShortCastlingIsBlocked() {
        aKing().at("E1").as(WHITE).thatMoved()
                .withBoard(BoardKingStubBuilder.aBoard()
                        .withKingNotInCheck()
                        .withRookAt("H1")
                        .withEmptySquare("F1")
                        .withEmptySquare("G1")
                        .withSafeSquare("F1")
                        .withSafeSquare("G1"))
                .cannotCastle();
    }

    @Test
    public void givenKingHasMoved_thenLongCastlingIsBlocked() {
        aKing().at("E1").as(WHITE).thatMoved()
                .withBoard(BoardKingStubBuilder.aBoard()
                        .withKingNotInCheck()
                        .withRookAt("A1")
                        .withEmptySquare("B1")
                        .withEmptySquare("C1")
                        .withEmptySquare("D1")
                        .withSafeSquare("B1")
                        .withSafeSquare("C1")
                        .withSafeSquare("D1"))
                .cannotCastle();
    }

    @Test
    public void givenRookHasMoved_thenShortCastlingIsBlocked() {
        aKing().at("E1").as(WHITE).fresh()
                .withBoard(BoardKingStubBuilder.aBoard()
                        .withKingNotInCheck()
                        .withoutRookAt("H1")
                        .withEmptySquare("F1")
                        .withEmptySquare("G1")
                        .withSafeSquare("F1")
                        .withSafeSquare("G1"))
                .cannotCastle();
    }

    @Test
    public void givenRookHasMoved_thenLongCastlingIsBlocked() {
        aKing().at("E1").as(WHITE).fresh()
                .withBoard(BoardKingStubBuilder.aBoard()
                        .withKingNotInCheck()
                        .withoutRookAt("A1")
                        .withEmptySquare("B1")
                        .withEmptySquare("C1")
                        .withEmptySquare("D1")
                        .withSafeSquare("B1")
                        .withSafeSquare("C1")
                        .withSafeSquare("D1"))
                .cannotCastle();
    }

    @Test
    public void givenKingIsInCheck_thenShortCastlingIsBlocked() {
        aKing().at("E1").as(WHITE).fresh()
                .withBoard(BoardKingStubBuilder.aBoard()
                        .withKingInCheck()
                        .withRookAt("H1")
                        .withEmptySquare("F1")
                        .withEmptySquare("G1")
                        .withSafeSquare("F1")
                        .withSafeSquare("G1"))
                .cannotCastle();
    }

    @Test
    public void givenTransitSquareIsOccupied_thenShortCastlingIsBlocked() {
        aKing().at("E1").as(WHITE).fresh()
                .withBoard(BoardKingStubBuilder.aBoard()
                        .withKingNotInCheck()
                        .withRookAt("H1")
                        .withOccupiedSquare("F1")
                        .withEmptySquare("G1")
                        .withSafeSquare("F1")
                        .withSafeSquare("G1"))
                .cannotCastle();
    }

    @Test
    public void givenTransitSquareIsOccupied_thenLongCastlingIsBlocked() {
        aKing().at("E1").as(WHITE).fresh()
                .withBoard(BoardKingStubBuilder.aBoard()
                        .withKingNotInCheck()
                        .withRookAt("A1")
                        .withOccupiedSquare("B1")
                        .withEmptySquare("C1")
                        .withEmptySquare("D1")
                        .withSafeSquare("B1")
                        .withSafeSquare("C1")
                        .withSafeSquare("D1"))
                .cannotCastle();
    }

    @Test
    public void givenTransitSquareIsAttacked_thenShortCastlingIsBlocked() {
        aKing().at("E1").as(WHITE).fresh()
                .withBoard(BoardKingStubBuilder.aBoard()
                        .withKingNotInCheck()
                        .withRookAt("H1")
                        .withEmptySquare("F1")
                        .withEmptySquare("G1")
                        .withAttackedSquare("F1")
                        .withSafeSquare("G1"))
                .cannotCastle();
    }

    @Test
    public void givenLandingSquareIsAttacked_thenShortCastlingIsBlocked() {
        aKing().at("E1").as(WHITE).fresh()
                .withBoard(BoardKingStubBuilder.aBoard()
                        .withKingNotInCheck()
                        .withRookAt("H1")
                        .withEmptySquare("F1")
                        .withEmptySquare("G1")
                        .withSafeSquare("F1")
                        .withAttackedSquare("G1"))
                .cannotCastle();
    }
}