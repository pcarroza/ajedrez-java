package org.citadel.models.pieces.rulesofmovements;

import org.citadel.models.pieces.Piece;

public class FacadeMotionManager {

    private FacadeMotionManager() {
    }

    public static MoveRulesManager createBishopMoveRulesManager(Piece piece) {
        return new BishopMoveRulesManager(piece);
    }

    public static MoveRulesManager createKingMoveRulesManager(Piece piece) {
        return new KingMoveRulesManager(piece);
    }

    public static MoveRulesManager createKnightMoveRulesManager(Piece piece) {
        return new KnightMoveRulesManager(piece);
    }

    public static MoveRulesManager createQueenMoveRulesManager(Piece piece) {
        return new QueenMoveRulesManager(piece);
    }

    public static MoveRulesManager createRookMoveRulesManager(Piece piece) {
        return new RookMoveRulesManager(piece);
    }

    public static MoveRulesManager createPawnMoveRulesManager(Piece piece) {
        return new PawnMoveRulesManager(piece);
    }
}