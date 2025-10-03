package org.citadel.views.console;

import org.citadel.controllers.local.LocalSpecialMovementsController;
import org.citadel.views.console.commands.special.CommandFactory;
import org.citadel.views.console.commands.special.NullCommand;

import java.util.List;

public class SpecialMovesMenu extends Menu {

    private final List<LocalSpecialMovementsController> controllers;

    public SpecialMovesMenu(List<LocalSpecialMovementsController> controllers) {
        super();
        this.controllers = controllers;
        this.setCommands();
    }

    @Override
    protected void setCommands() {
        CommandFactory commandFactory = new CommandFactory();
        for (LocalSpecialMovementsController controller : controllers) {
            controller.accept(commandFactory);
            this.commands.add(commandFactory.getCommand());
        }
        this.commands.add(new NullCommand());
    }
}
