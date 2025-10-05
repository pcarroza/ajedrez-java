package org.citadel.views.console.commands.game;

import org.citadel.controllers.GameController;
import org.citadel.views.console.commands.Command;

public class ShowHistoryCommand implements Command {

    private final GameController gameController;

    public ShowHistoryCommand(GameController menuController) {
        this.gameController = menuController;
    }

    @Override
    public void execute() {
        gameController.showHistory();
    }
}
