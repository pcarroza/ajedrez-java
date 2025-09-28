package org.citadel.views.console;

import org.citadel.controllers.PlacementController;
import org.citadel.controllers.PutPieceController;
import org.citadel.controllers.SelectPieceController;

public class GameView {

    private final BoardView boardView;

    private final SpecialMovesView specialMovementsView;

    public GameView() {
        this.boardView = new BoardView();
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
        assert putPieceController != null;
        boardView.write();
    }
}
