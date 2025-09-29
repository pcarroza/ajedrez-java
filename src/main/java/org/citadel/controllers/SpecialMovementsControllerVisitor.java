package org.citadel.controllers;

public interface SpecialMovementsControllerVisitor {

    void visit(CastlingMovesController castlingMovesController);

    void visit(EnPassantPawnController enPassantPawnController);

    void visit(PromotionController promotionController);
}
