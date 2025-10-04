package org.citadel.controllers.local;

import org.citadel.controllers.EnPassantPawnController;
import org.citadel.controllers.SpecialMovementsControllerVisitor;
import org.citadel.models.Game;

public class LocalEnPassantPawnController extends LocalSpecialMovementsController implements EnPassantPawnController {

    public LocalEnPassantPawnController(Game game) {
        super(game);
    }

    @Override
    public boolean isApplicable() {
        // TODO: Implementar lógica
        return false;
    }

    @Override
    public void capture() {
        // TODO: Implementar lógica
    }

    @Override
    public void accept(SpecialMovementsControllerVisitor specialMovementsControllerVisitor) {
        specialMovementsControllerVisitor.visit(this);
    }
}
