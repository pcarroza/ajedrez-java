package org.citadel.views.console.commands.special;

import org.citadel.controllers.modules.game.CastlingMovesController;
import org.citadel.controllers.modules.game.EnPassantPawnController;
import org.citadel.controllers.modules.game.PromotionPawnController;
import org.citadel.controllers.modules.game.SpecialMovementsControllerVisitor;
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
