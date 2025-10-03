package org.citadel.views.console.commands.special;

import org.citadel.controllers.CastlingMovesController;
import org.citadel.controllers.EnPassantPawnController;
import org.citadel.controllers.PromotionPawnController;
import org.citadel.controllers.SpecialMovementsControllerVisitor;
import org.citadel.views.console.commands.Command;

public class CommandFactory implements SpecialMovementsControllerVisitor {

    private Command command;

    public Command getCommand() {
        return command;
    }

    @Override
    public void visit(CastlingMovesController controller) {
        command = new CastlingMoveCommand(controller);
    }

    @Override
    public void visit(EnPassantPawnController controller) {
        command = new EnPassantPawnCommand(controller);
    }

    @Override
    public void visit(PromotionPawnController controller) {
        command = new PromotionPawnCommand(controller);
    }
}
