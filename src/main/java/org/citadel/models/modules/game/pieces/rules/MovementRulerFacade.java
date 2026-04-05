package org.citadel.models.modules.game.pieces.rules;

public class MovementRulerFacade {

    private MovementRulerFacade() {
    }

    public static MovementRuleGenerator getBishopMoveRulesBuilder() {
        return BishopRulerGenerator.getInstance();
    }

    public static MovementRuleGenerator getKingMoveRulesBuilder() {
        return KingRulesGenerator.getInstance();
    }

    public static MovementRuleGenerator getKnightMoveRulesBuilder() {
        return KnightRulerGenerator.getInstance();
    }

    public static MovementRuleGenerator getQueenMoveRulesBuilder() {
        return QueenRulerGenerator.getInstance();
    }

    public static MovementRuleGenerator getRookMoveRulesBuilder() {
        return RookRulerGenerator.getInstance();
    }

    public static MovementRuleGenerator getPawnMoveRulesBuilder() {
        return PawnRulerGenerator.getInstance();
    }
}