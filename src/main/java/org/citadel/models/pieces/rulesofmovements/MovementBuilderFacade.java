package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Piece;

public class MovementBuilderFacade {

    private MovementBuilderFacade() {
    }

    public static MovementRuleBuilder createBishopMoveRulesBuilder(Piece piece) {
        return new BishopMovementRuleBuilder(piece);
    }

    public static MovementRuleBuilder createKingMoveRulesBuilder(Piece piece) {
        return new KingMovementRuleBuilder(piece);
    }

    public static MovementRuleBuilder createKnightMoveRulesBuilder(Piece piece) {
        return new KnightMovementRuleBuilder(piece);
    }

    public static MovementRuleBuilder createQueenMoveRulesBuilder(Piece piece) {
        return new QueenMovementRuleBuilder(piece);
    }

    public static MovementRuleBuilder createRookMoveRulesBuilder(Piece piece) {
        return new RookMovementRuleBuilder(piece);
    }

    public static MovementRuleBuilder createPawnMoveRulesBuilder(Piece piece) {
        return new PawnMovementRuleBuilder(piece);
    }
}