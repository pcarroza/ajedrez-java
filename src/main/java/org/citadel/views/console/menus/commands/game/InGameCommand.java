package org.citadel.views.console.menus.commands.game;

import org.citadel.controllers.GameController;
import org.citadel.views.console.menus.commands.Command;

public class InGameCommand extends Command {

    private final GameController gameController;

    public InGameCommand(String title, GameController menuController) {
        super(title);
        this.gameController = menuController;
    }

    @Override
    public void execute() {
        gameController.startNewGame();
    }
}
