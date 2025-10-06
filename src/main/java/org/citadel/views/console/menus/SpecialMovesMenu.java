package org.citadel.views.console.menus;

import org.citadel.controllers.SpecialMovementsController;
import org.citadel.views.console.commands.special.MenuItemFactory;
import org.citadel.views.console.commands.special.NullCommand;

import java.util.List;

public class SpecialMovesMenu extends Menu {

    public SpecialMovesMenu(List<? extends SpecialMovementsController> controllers) {
        super("MOVIMIENTOS ESPECIALES");
        MenuItemFactory menuItemFactory = new MenuItemFactory();
        for (SpecialMovementsController controller : controllers) {
            controller.accept(menuItemFactory);
            this.add(menuItemFactory.getMenuItem());
        }
        this.add(new MenuItem("Ninguno", new NullCommand()));
    }
}
