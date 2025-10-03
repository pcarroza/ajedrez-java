package org.citadel.views.console.commands.game;

import org.citadel.controllers.MenuController;
import org.citadel.views.console.commands.Command;

public class ExitCommand extends Command {

    private final MenuController menuController;

    public ExitCommand(String title, MenuController menuController) {
        super(title);
        this.menuController = menuController;
    }

    @Override
    public void execute() {
        menuController.exitGame();
    }
}
