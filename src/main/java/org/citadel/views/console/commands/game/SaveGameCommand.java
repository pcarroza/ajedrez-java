package org.citadel.views.console.commands.game;

import org.citadel.controllers.GameController;
import org.citadel.views.console.commands.Command;

public class SaveGameCommand extends Command {

    private final GameController gameController;

    public SaveGameCommand(String title, GameController menuController) {
        super(title);
        this.gameController = menuController;
    }

    @Override
    public void execute() {
        gameController.saveGame();
    }
}
