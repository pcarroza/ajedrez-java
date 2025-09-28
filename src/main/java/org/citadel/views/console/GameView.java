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
        assert selectPieceController != null;
        boardView.interact(selectPieceController);
    }

    public void visit(PutPieceController putPieceController) {
        assert putPieceController != null;
        boardView.interact(putPieceController);
    }
}
