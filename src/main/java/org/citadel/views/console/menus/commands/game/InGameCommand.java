package org.citadel.views.console.menus.commands.game;

import org.citadel.controllers.GameController;
import org.citadel.views.console.menus.commands.Command;

public class InGameCommand extends Command {

    private final GameController gameController;

    public InGameCommand(String title, GameController gameController) {
        super(title);
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
