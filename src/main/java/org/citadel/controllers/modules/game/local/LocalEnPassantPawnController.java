package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.EnPassantPawnController;
import org.citadel.controllers.modules.game.SpecialMovementsControllerVisitor;
import org.citadel.models.modules.game.Game;

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
