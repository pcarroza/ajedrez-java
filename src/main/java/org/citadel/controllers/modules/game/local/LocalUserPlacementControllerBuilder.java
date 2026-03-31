package org.citadel.controllers.modules.game.local;

import org.citadel.models.Game;

public class LocalUserPlacementControllerBuilder extends LocalPlacementControllerBuilder {

    private Game game;

    public LocalUserPlacementControllerBuilder(Game game) {
        this.game = game;
    }
}
