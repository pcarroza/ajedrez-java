package org.citadel.views.console.commands.game;

import org.citadel.controllers.GameController;
import org.citadel.views.console.commands.Command;

public class LoadGameCommand implements Command {

    private final GameController gameController;

    public LoadGameCommand(GameController menuController) {
        this.gameController = menuController;
    }

    @Override
    public void execute() {
        gameController.loadGame();
    }

    @Override
    public boolean isActive() {
        return !gameController.isGameInProgress();
    }
}
