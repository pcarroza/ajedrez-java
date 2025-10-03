package org.citadel.views.console.commands;

import org.citadel.controllers.MenuController;

public class NewGameCommand extends Command {

    private final MenuController menuController;

    public NewGameCommand(String title, MenuController menuController) {
        super(title);
        this.menuController = menuController;
    }

    @Override
    public void execute() {
        menuController.startNewGame();
    }
}
