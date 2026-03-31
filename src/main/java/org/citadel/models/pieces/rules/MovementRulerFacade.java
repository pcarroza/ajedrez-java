package org.citadel.models.pieces.rules;

public class MovementRulerFacade {

    private MovementRulerFacade() {
    }

    public static MovementRuler getBishopMoveRulesBuilder() {
        return BishopRuler.getInstance();
    }

    public static MovementRuler getKingMoveRulesBuilder() {
        return KingRules.getInstance();
    }

    public static MovementRuler getKnightMoveRulesBuilder() {
        return KnightRuler.getInstance();
    }

    public static MovementRuler getQueenMoveRulesBuilder() {
        return QueenRuler.getInstance();
    }

    public static MovementRuler getRookMoveRulesBuilder() {
        return RookRuler.getInstance();
    }

    public static MovementRuler getPawnMoveRulesBuilder() {
        return PawnRuler.getInstance();
    }
}