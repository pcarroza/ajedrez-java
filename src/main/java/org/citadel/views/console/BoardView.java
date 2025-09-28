package org.citadel.views.console;

import org.citadel.controllers.PlacementController;
import org.citadel.controllers.PutPieceController;
import org.citadel.controllers.SelectPieceController;

public class BoardView {

    private final SpecialMovesView specialMovementsView;

    public BoardView() {
        this.specialMovementsView = new SpecialMovesView();
    }

    public void interact(PlacementController placementController) {
        placementController.accept(null);
    }

    public void visit(SelectPieceController selectPieceController) {
        selectPieceController.select(null);
        if (selectPieceController.hasSpecialMovements()) {
            specialMovementsView.interact(selectPieceController);
        }

    }

    public void visit(PutPieceController putPieceController) {
    }
}
