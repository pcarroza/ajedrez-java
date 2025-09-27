package org.citadel.controllers.local;

import org.citadel.models.Game;

public abstract class LocalSpecialMovementsController implements LocalSpecialMovementsControllerComponent {

    protected Game game;

    LocalSpecialMovementsController(Game game) {
        this.game = game;
    }

    public abstract boolean isApplicable();

    public LocalSpecialMovementsController getSpecialMoveController() {
        return this;
    }
}
