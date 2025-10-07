package org.citadel.views.console;

import org.citadel.View;
import org.citadel.controllers.GameController;
import org.citadel.controllers.OperationController;
import org.citadel.views.console.menus.MenuContext;
import org.citadel.views.console.menus.StartMenuView;
import org.citadel.views.console.menus.Menu;

public class ConsoleView implements View {

    @Override
    public void interact(OperationController operationController) {
        operationController.accept(this);
    }

    public void visit(GameController gameController) {
        MenuContext context = new MenuContext();
        Menu startMenuView = new StartMenuView(gameController, context);
        context.start(startMenuView);
        while (!context.isExited()) {
            context.execute();
        }
    }
}
