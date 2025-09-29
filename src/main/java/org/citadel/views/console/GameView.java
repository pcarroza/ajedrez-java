package org.citadel.views.console;

import org.citadel.controllers.PlacementController;
import org.citadel.controllers.PlacementControllerVisitor;
import org.citadel.controllers.PutPieceController;
import org.citadel.controllers.SelectPieceController;
import org.citadel.models.pieces.Coordinate;

public class GameView implements PlacementControllerVisitor {

    private final BoardView boardView;

    private final SpecialMovesView specialMovesView;

    private Coordinate target;

    public GameView() {
        this.boardView = new BoardView();
        this.specialMovesView = new SpecialMovesView();
        this.target = null;
    }

    public void interact(PlacementController placementController) {
        placementController.accept(this);
    }

    public void visit(SelectPieceController selectPieceController) {
        selectPieceController.select(new Coordinate());
        if (selectPieceController.hasSpecialMovements()) {
            specialMovesView.interact(selectPieceController.getSpecialMovements());
        }
    }

    public void visit(PutPieceController putPieceController) {
        assert putPieceController != null;
        boardView.write();
    }
}
