package org.citadel.views.console;

import org.citadel.View;
import org.citadel.controllers.GameController;
import org.citadel.controllers.OperationController;
import org.citadel.views.console.menus.GameMenuView;
import org.citadel.views.console.menus.MenuContext;
import org.citadel.views.console.menus.Menu;

public class ConsoleView implements View {

    @Override
    public void interact(OperationController operationController) {
        operationController.accept(this);
    }

    public void visit(GameController gameController) {
        MenuContext context = new MenuContext();
        Menu gameMenuView = new GameMenuView(gameController, context);
        context.setCurrentMenu(gameMenuView);
        while (true) {
            context.execute();
        }
    }
}
