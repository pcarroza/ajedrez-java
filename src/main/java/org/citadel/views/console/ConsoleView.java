package org.citadel.views.console;

import org.citadel.View;
import org.citadel.controllers.ContinueController;
import org.citadel.controllers.GameController;
import org.citadel.controllers.OperationController;
import org.citadel.controllers.StartController;
import org.citadel.views.console.menus.GameMenuView;

public class ConsoleView implements View {

    private final StartView startView;

    private final ContinueView continueView;

    public ConsoleView() {
        startView = new StartView();
        continueView = new ContinueView();
    }

    @Override
    public void interact(OperationController operationController) {
        operationController.accept(this);
    }

    public void visit(StartController startController) {
        startView.interact(startController);
    }

    public void visit(GameController gameController) {
        new GameMenuView(gameController).execute();
    }

    public void visit(ContinueController continueController) {
        continueView.interact(continueController);
    }
}
