package org.citadel.views.console.menus;

import org.citadel.controllers.SpecialMovementsController;
import org.citadel.views.console.menus.commands.special.CommandFactory;
import org.citadel.views.console.menus.commands.special.NullCommand;

import java.util.List;

public class SpecialMovesMenu extends Menu {

    private final List<SpecialMovementsController> controllers;

    public SpecialMovesMenu(List<SpecialMovementsController> controllers) {
        super();
        this.controllers = controllers;
        this.setCommands();
    }

    @Override
    protected void setCommands() {
        CommandFactory commandFactory = new CommandFactory();
        for (SpecialMovementsController controller : controllers) {
            controller.accept(commandFactory);
            this.commands.add(commandFactory.getCommand());
        }
        this.commands.add(new NullCommand());
    }
}
