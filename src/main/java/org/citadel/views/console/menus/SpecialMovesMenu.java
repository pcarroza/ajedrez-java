package org.citadel.views.console.menus;

import org.citadel.controllers.SpecialMovementsController;
import org.citadel.views.console.menus.commands.special.CommandFactory;
import org.citadel.views.console.menus.commands.special.NullCommand;

import java.util.List;

public class SpecialMovesMenu extends Menu {

    public SpecialMovesMenu(List<? extends SpecialMovementsController> controllers) {
        super("MOVIMIENTOS ESPECIALES");
        CommandFactory commandFactory = new CommandFactory();
        for (SpecialMovementsController controller : controllers) {
            controller.accept(commandFactory);
            this.add(commandFactory.getCommand());
        }
        this.add(new NullCommand());
    }
}
