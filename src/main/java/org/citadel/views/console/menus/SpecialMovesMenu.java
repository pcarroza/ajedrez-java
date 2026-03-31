package org.citadel.views.console.menus;

import org.citadel.controllers.SpecialMovementsController;
import org.citadel.views.console.commands.game.BackCommand;
import org.citadel.views.console.commands.special.MenuItemFactory;

import java.util.List;

public class SpecialMovesMenu extends Menu {

    public SpecialMovesMenu(List<? extends SpecialMovementsController> controllers, MenuContext context) {
        super("MOVIMIENTOS ESPECIALES");
        MenuItemFactory menuItemFactory = new MenuItemFactory();
        for (SpecialMovementsController controller : controllers) {
            controller.accept(menuItemFactory);
            add(menuItemFactory.getMenuItem());
        }
        if (context != null) {
            add(new MenuItem("VOLVER ATRÁS", new BackCommand(context)));
        }
    }
}