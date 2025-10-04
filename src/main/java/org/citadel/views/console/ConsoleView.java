package org.citadel.views.console;

import org.citadel.View;
import org.citadel.controllers.GameController;
import org.citadel.controllers.OperationController;
import org.citadel.views.console.menus.GameMenuView;

public class ConsoleView implements View {

    @Override
    public void interact(OperationController operationController) {
        operationController.accept(this);
    }

    public void visit(GameController gameController) {
        new GameMenuView(gameController).execute();
    }
}
