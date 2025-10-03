package org.citadel.views.console;

import org.citadel.View;
import org.citadel.controllers.ContinueController;
import org.citadel.controllers.GameController;
import org.citadel.controllers.MenuController;
import org.citadel.controllers.OperationController;
import org.citadel.controllers.PlacementController;
import org.citadel.controllers.StartController;

public class ConsoleView implements View {

    private final StartView startView;

    private final GameView gameView;

    private final ContinueView continueView;

    public ConsoleView() {
        startView = new StartView();
        gameView = new GameView();
        continueView = new ContinueView();
    }

    public void interact(GameController gameController) {
        gameController.accept(this);
    }

    @Override
    public void interact(OperationController operationController) {
        // TODO Auto-generated method stub
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

    public void visit(MenuController menuController) {
        new MainMenuView(menuController).execute();
    }
}
