package org.citadel.views.console;

import java.util.List;

import org.citadel.controllers.CastlingMovesController;
import org.citadel.controllers.EnPassantPawnController;
import org.citadel.controllers.PromotionPawnController;
import org.citadel.controllers.PutPieceController;
import org.citadel.controllers.SpecialMovementsController;
import org.citadel.controllers.SpecialMovementsControllerVisitor;

public class SpecialMovesView implements SpecialMovementsControllerVisitor {

    private PutPieceController putPieceController;

    public SpecialMovesView() {
    }

    public void set(PutPieceController putPieceController) {
        this.putPieceController = putPieceController;
    }

    public void interact(List<? extends SpecialMovementsController> specialMovementsControllers) {
        for (SpecialMovementsController specialController : specialMovementsControllers) {
            specialController.accept(this);
        }
    }

    @Override
    public void visit(EnPassantPawnController enPassantPawnController) {
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(CastlingMovesController castlingMovesController) {
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(PromotionPawnController promotionPawnController) {
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }
}
