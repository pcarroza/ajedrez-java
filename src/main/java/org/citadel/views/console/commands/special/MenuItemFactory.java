package org.citadel.views.console.commands.special;

import org.citadel.controllers.CastlingMovesController;
import org.citadel.controllers.EnPassantPawnController;
import org.citadel.controllers.PromotionPawnController;
import org.citadel.controllers.SpecialMovementsControllerVisitor;
import org.citadel.views.console.menus.MenuItem;

public class MenuItemFactory implements SpecialMovementsControllerVisitor {

    private MenuItem menuItem;

    public MenuItem getMenuItem() {
        return menuItem;
    }

    @Override
    public void visit(CastlingMovesController controller) {
        menuItem = new MenuItem("ENROQUE", new CastlingMoveCommand(controller));
    }

    @Override
    public void visit(EnPassantPawnController controller) {
        menuItem = new MenuItem("CAPTURA AL PASO", new EnPassantPawnCommand(controller));
    }

    @Override
    public void visit(PromotionPawnController controller) {
        menuItem = new MenuItem("PROMOCIÓN DE PEÓN", new PromotionPawnCommand(controller));
    }
}
