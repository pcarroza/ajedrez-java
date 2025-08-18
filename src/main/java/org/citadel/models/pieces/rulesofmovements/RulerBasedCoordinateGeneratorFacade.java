package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Piece;

public class RulerBasedCoordinateGeneratorFacade {

    private RulerBasedCoordinateGeneratorFacade() {
    }

    public static MovementRulesBaseGenerator createBishopMoveRulesBuilder(Piece piece) {
        return new BishopMovementRulesBaseGenerator(piece);
    }

    public static MovementRulesBaseGenerator createKingMoveRulesBuilder(Piece piece) {
        return new KingMovementRulesBaseGenerator(piece);
    }

    public static MovementRulesBaseGenerator createKnightMoveRulesBuilder(Piece piece) {
        return new KnightMovementRulesBaseGenerator(piece);
    }

    public static MovementRulesBaseGenerator createQueenMoveRulesBuilder(Piece piece) {
        return new QueenMovementRulesBaseGenerator(piece);
    }

    public static MovementRulesBaseGenerator createRookMoveRulesBuilder(Piece piece) {
        return new RookMovementRulesBaseGenerator(piece);
    }

    public static MovementRulesBaseGenerator createPawnMoveRulesBuilder(Piece piece) {
        return new PawnMovementRulesBaseGenerator(piece);
    }
}