package org.citadel.controllers.modules.game;

public interface SpecialMovementsControllerVisitor {

    void visit(CastlingMovesController castlingMovesController);

    void visit(EnPassantPawnController enPassantPawnController);

    void visit(PromotionPawnController promotionController);
}
