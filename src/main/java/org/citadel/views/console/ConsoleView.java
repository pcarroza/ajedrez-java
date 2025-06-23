package org.citadel.views.console;

import org.citadel.View;
import org.citadel.controllers.ContinueController;
import org.citadel.controllers.OperationController;
import org.citadel.controllers.PlacementController;
import org.citadel.controllers.StartController;

public class ConsoleView implements View {

    private StartView startView;

    private GameView gameView;

    private ContinueView continueView;

    public ConsoleView() {
        startView = new StartView();
        gameView = new GameView();
        continueView = new ContinueView();
    }

    @Override
    public void interact() {
        throw new UnsupportedOperationException("Unimplemented method 'interact'");
    }

    public void visit(StartController startController) {
        startView.interact(startController);
    }

    public void visit(PlacementController placementController) {
        gameView.interact(placementController);
    }

    public void visit(ContinueController continueController) {
        continueView.interact(continueController);
    }
}
