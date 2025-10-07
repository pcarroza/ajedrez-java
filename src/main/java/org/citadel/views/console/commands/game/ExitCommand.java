package org.citadel.views.console.commands.game;

import org.citadel.views.console.commands.Command;
import org.citadel.views.console.menus.MenuContext;

public class ExitCommand implements Command {

    private final MenuContext context;

    public ExitCommand(MenuContext context) {
        this.context = context;
    }

    @Override
    public void execute() {
        context.exit();
    }
}