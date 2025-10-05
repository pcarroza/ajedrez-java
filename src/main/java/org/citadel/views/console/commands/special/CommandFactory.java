package org.citadel.views.console.commands.special;

import org.citadel.controllers.CastlingMovesController;
import org.citadel.controllers.EnPassantPawnController;
import org.citadel.controllers.PromotionPawnController;
import org.citadel.controllers.SpecialMovementsControllerVisitor;
import org.citadel.views.console.menus.MenuItem;

public class CommandFactory implements SpecialMovementsControllerVisitor {

    private MenuItem menuItem;

    public MenuItem getMenuItem() {
        return menuItem;
    }

    @Override
    public void visit(CastlingMovesController controller) {
        menuItem = new MenuItem("Enroque", new CastlingMoveCommand(controller));
    }

    @Override
    public void visit(EnPassantPawnController controller) {
        menuItem = new MenuItem("Captura al Paso", new EnPassantPawnCommand(controller));
    }

    @Override
    public void visit(PromotionPawnController controller) {
        menuItem = new MenuItem("Promoción de Peón", new PromotionPawnCommand(controller));
    }
}
