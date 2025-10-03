package org.citadel.views.console.commands.game;

import org.citadel.controllers.MenuController;
import org.citadel.views.console.commands.Command;

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
