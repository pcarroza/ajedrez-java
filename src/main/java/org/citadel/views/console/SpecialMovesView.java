package org.citadel.views.console;

import java.util.List;

import org.citadel.controllers.CastlingMovesController;
import org.citadel.controllers.EnPassantPawnController;
import org.citadel.controllers.PromotionController;
import org.citadel.controllers.PutPieceController;
import org.citadel.controllers.SpecialMovementsController;

public class SpecialMovesView {

    private PutPieceController putPieceController;

    public SpecialMovesView() {
    }

    public void set(PutPieceController putPieceController) {
        this.putPieceController = putPieceController;
    }

    public void interact(List<SpecialMovementsController> specialMovementsControllers) {
        specialMovementsControllers.forEach((controller) -> controller.accept(this));
    }

    public void vist(EnPassantPawnController enPassantPawnController) {
    }

    public void visit(CastlingMovesController castlingMovesController) {
    }

    public void visit(PromotionController promotionController) {
    }
}
