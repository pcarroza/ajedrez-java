package org.citadel.views.console;

import org.citadel.controllers.PlacementController;
import org.citadel.controllers.PlacementControllerVisitor;
import org.citadel.controllers.PutPieceController;
import org.citadel.controllers.SelectPieceController;
import org.citadel.models.pieces.Coordinate;

public class GameView implements PlacementControllerVisitor {

    private final BoardView boardView;

    private final SpecialMovesView specialMovesView;

    public GameView() {
        this.boardView = new BoardView();
        this.specialMovesView = new SpecialMovesView();
    }

    public void interact(PlacementController placementController) {
        placementController.accept(this);
    }

    public void visit(SelectPieceController selectPieceController) {
        selectPieceController.select(new Coordinate());
        if (selectPieceController.hasSpecialMovements()) {
            specialMovesView.interact(selectPieceController);
        }
    }

    public void visit(PutPieceController putPieceController) {
        assert putPieceController != null;
        boardView.write();
    }
}
