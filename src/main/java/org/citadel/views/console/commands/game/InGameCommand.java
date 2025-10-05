package org.citadel.views.console.commands.game;

import org.citadel.controllers.GameController;
import org.citadel.views.console.commands.Command;

public class InGameCommand implements Command {

    private final GameController gameController;

    public InGameCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        gameController.startNewGame();
    }

    @Override
    public boolean isActive() {
        return !gameController.isGameInProgress();
    }
}
