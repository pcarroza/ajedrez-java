package org.citadel.controllers.local;

import org.citadel.controllers.SpecialMovementsControllerVisitor;
import org.citadel.controllers.CastlingMovesController;
import org.citadel.models.Game;

public class LocalCastlingMovesController extends LocalSpecialMovementsController implements CastlingMovesController {

    public LocalCastlingMovesController(Game game) {
        super(game);
    }

    @Override
    public boolean isApplicable() {
        return false;
    }

    @Override
    public void accept(SpecialMovementsControllerVisitor specialMovementsControllerVisitor) {
        specialMovementsControllerVisitor.visit(this);
    }
}
