package org.citadel.controllers.local;

import org.citadel.controllers.SpecialMovementsController;
import org.citadel.controllers.SpecialMovementsControllerVisitor;
import org.citadel.models.Game;

public abstract class LocalSpecialMovementsController implements SpecialMovementsController {

    protected Game game;

    LocalSpecialMovementsController(Game game) {
        this.game = game;
    }

    public LocalSpecialMovementsController getSpecialMoveController() {
        return this;
    }

    public abstract boolean isApplicable();

    public abstract String getName();

    public abstract void accept(SpecialMovementsControllerVisitor specialMovementsControllerVisitor);
}
