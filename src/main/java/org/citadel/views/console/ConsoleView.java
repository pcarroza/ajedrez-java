package org.citadel.views.console;

import org.citadel.controllers.ContinueController;
import org.citadel.controllers.OperationController;
import org.citadel.controllers.PlacementController;
import org.citadel.controllers.StartController;

public class ConsoleView {

    private StartView startView;

    private BoardView boardView;

    private ContinueView continueView;

    public ConsoleView() {
        startView = new StartView();
        boardView = new BoardView();
        continueView = new ContinueView();
    }

    public void interact(OperationController operationController) {
        operationController.accept(this);
    }

    public void visit(StartController startController) {
        startView.interact(startController);
    }

    public void visit(PlacementController placementController) {
        boardView.interact(placementController);
    }

    public void visit(ContinueController continueController) {
        continueView.interact(continueController);
    }
}
