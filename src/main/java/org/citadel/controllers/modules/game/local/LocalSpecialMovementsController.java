package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.SpecialMovementsController;
import org.citadel.controllers.modules.game.SpecialMovementsControllerVisitor;
import org.citadel.models.modules.game.Game;

public abstract class LocalSpecialMovementsController implements SpecialMovementsController {

    protected Game game;

    LocalSpecialMovementsController(Game game) {
        this.game = game;
    }

    public LocalSpecialMovementsController getSpecialMoveController() {
        return this;
    }

    public abstract boolean isApplicable();

    public abstract void accept(SpecialMovementsControllerVisitor specialMovementsControllerVisitor);
}
