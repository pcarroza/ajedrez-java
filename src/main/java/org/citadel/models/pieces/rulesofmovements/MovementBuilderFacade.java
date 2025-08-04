package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Piece;

public class MovementBuilderFacade {

    private MovementBuilderFacade() {
    }

    public static RuleBasedCoordinateGenerator createBishopMoveRulesBuilder(Piece piece) {
        return new BishopRuleBasedCoordinateGenerator(piece);
    }

    public static RuleBasedCoordinateGenerator createKingMoveRulesBuilder(Piece piece) {
        return new KingRuleBasedCoordinateGenerator(piece);
    }

    public static RuleBasedCoordinateGenerator createKnightMoveRulesBuilder(Piece piece) {
        return new KnightRuleBasedCoordinateGenerator(piece);
    }

    public static RuleBasedCoordinateGenerator createQueenMoveRulesBuilder(Piece piece) {
        return new QueenRuleBasedCoordinateGenerator(piece);
    }

    public static RuleBasedCoordinateGenerator createRookMoveRulesBuilder(Piece piece) {
        return new RookRuleBasedCoordinateGenerator(piece);
    }

    public static RuleBasedCoordinateGenerator createPawnMoveRulesBuilder(Piece piece) {
        return new PawnRuleBasedCoordinateGenerator(piece);
    }
}