package org.citadel.views.console;

import org.citadel.controllers.PlacementController;
import org.citadel.controllers.PutPieceController;
import org.citadel.controllers.SelectPieceController;

public class GameView {

    private final BoardView boardView;

    public GameView() {
        this.boardView = new BoardView();
    }

    public void interact(PlacementController placementController) {
        boardView.interact(placementController);
    }

    public void visit(SelectPieceController selectPieceController) {
        
    }

    public void visit(PutPieceController putPieceController) {
    }
}
