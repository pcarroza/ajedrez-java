package org.citadel.views.console.commands;

import org.citadel.controllers.MenuController;

public class ShowHistoryCommand extends Command {

    private final MenuController menuController;

    public ShowHistoryCommand(String title, MenuController menuController) {
        super(title);
        this.menuController = menuController;
    }

    @Override
    public void execute() {
        menuController.showHistory();
    }
}
