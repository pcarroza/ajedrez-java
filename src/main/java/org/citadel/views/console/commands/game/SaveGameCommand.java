package org.citadel.views.console.commands.game;

import org.citadel.controllers.modules.game.GameController;
import org.citadel.views.console.commands.Command;

public class SaveGameCommand implements Command {

    private final GameController gameController;

    public SaveGameCommand(GameController menuController) {
        this.gameController = menuController;
    }

    @Override
    public void execute() {
        gameController.saveGame();
    }

    @Override
    public boolean isActive() {
        return gameController.isGameInProgress();
    }
}
