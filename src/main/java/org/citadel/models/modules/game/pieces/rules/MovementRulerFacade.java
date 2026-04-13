package org.citadel.models.modules.game.pieces.rules;

import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;

public class MovementRulerFacade {

    private MovementRulerFacade() {
    }

    public static MovementRuleGenerator<Bishop> getBishopMoveRulesBuilder() {
        return BishopRulerGenerator.getInstance();
    }

    public static MovementRuleGenerator<King> getKingMoveRulesBuilder() {
        return KingRulesGenerator.getInstance();
    }

    public static MovementRuleGenerator<Knight> getKnightMoveRulesBuilder() {
        return KnightRulerGenerator.getInstance();
    }

    public static MovementRuleGenerator<Queen> getQueenMoveRulesBuilder() {
        return QueenRulerGenerator.getInstance();
    }

    public static MovementRuleGenerator<Rook> getRookMoveRulesBuilder() {
        return RookRulerGenerator.getInstance();
    }

    public static MovementRuleGenerator<Pawn> getPawnMoveRulesBuilder() {
        return PawnRulerGenerator.getInstance();
    }
}