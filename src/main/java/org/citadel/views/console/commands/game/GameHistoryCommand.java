package org.citadel.views.console.commands.game;

import org.citadel.controllers.modules.game.GameController;
import org.citadel.views.console.commands.Command;

public class GameHistoryCommand implements Command {

    private final GameController gameController;

    public GameHistoryCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        gameController.showHistory();
    }
}
