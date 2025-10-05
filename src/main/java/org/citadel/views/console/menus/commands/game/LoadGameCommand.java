package org.citadel.views.console.menus.commands.game;

import org.citadel.controllers.GameController;
import org.citadel.views.console.menus.commands.Command;

public class LoadGameCommand extends Command {

    private final GameController gameController;

    public LoadGameCommand(String title, GameController menuController) {
        super(title);
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
