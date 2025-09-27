package org.citadel.controllers.local;

import org.citadel.models.Game;

public abstract class LocalSpecialMovementsController implements LocalSpecialMovementsControllerComponent {

    private Game game;

    LocalSpecialMovementsController(Game game) {
        this.game = game;
    }

    public abstract  void execute();

}
