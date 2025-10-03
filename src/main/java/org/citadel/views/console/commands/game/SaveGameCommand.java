package org.citadel.views.console.commands;

import org.citadel.controllers.MenuController;

public class SaveGameCommand extends Command {

    private final MenuController menuController;

    public SaveGameCommand(String title, MenuController menuController) {
        super(title);
        this.menuController = menuController;
    }

    @Override
    public void execute() {
        menuController.saveGame();
    }
}
