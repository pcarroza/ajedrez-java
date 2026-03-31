package org.citadel.views.console;

import org.citadel.View;
import org.citadel.controllers.OperationController;
import org.citadel.controllers.local.*;
import org.citadel.views.console.menus.MenuContext;
import org.citadel.views.console.menus.StartMenuView;
import org.citadel.views.console.menus.Menu;

public class ConsoleView implements View {

    private final StartView startView = new StartView();

    private final GameView gameView = new GameView();

    private final ContinueView continueView = new ContinueView();

    @Override
    public void interact(OperationController operationController) {
        operationController.accept(this);
    }

    @Override
    public void visit(LocalStartController startController) {
        startView.interact(startController);
    }

    @Override
    public void visit(LocalGameController gameController) {
        MenuContext context = new MenuContext();
        Menu startMenuView = new StartMenuView(gameController, context);
        context.start(startMenuView);
        while (!context.isExited()) {
            context.execute();
        }
    }

    @Override
    public void visit(LocalContinueController continueController) {
        continueView.interact(continueController);
    }

    @Override
    public void visit(LocalPutPieceController putPieceController) {
        gameView.interact(putPieceController);
    }

    @Override
    public void visit(LocalSelectPieceController selectPieceController) {
        gameView.interact(selectPieceController);
    }
}