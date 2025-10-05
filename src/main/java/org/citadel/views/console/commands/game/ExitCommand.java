package org.citadel.views.console.commands.game;

import org.citadel.controllers.GameController;
import org.citadel.views.console.commands.Command;

public class ExitCommand implements Command {

    private final GameController gameController;

    public ExitCommand(GameController menuController) {
        super();
        this.gameController = menuController;
    }

    @Override
    public void execute() {
        gameController.exitGame();
    }
}
