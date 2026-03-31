package org.citadel.models.pieces.rules;

public class MovementBaseGeneratorFacade {

    private MovementBaseGeneratorFacade() {
    }

    public static MovementBaseGenerator getBishopMoveRulesBuilder() {
        return BishopGenerator.getInstance();
    }

    public static MovementBaseGenerator getKingMoveRulesBuilder() {
        return KingGenerator.getInstance();
    }

    public static MovementBaseGenerator getKnightMoveRulesBuilder() {
        return KnightGenerator.getInstance();
    }

    public static MovementBaseGenerator getQueenMoveRulesBuilder() {
        return QueenGenerator.getInstance();
    }

    public static MovementBaseGenerator getRookMoveRulesBuilder() {
        return RookGenerator.getInstance();
    }

    public static MovementBaseGenerator getPawnMoveRulesBuilder() {
        return PawnGenerator.getInstance();
    }
}