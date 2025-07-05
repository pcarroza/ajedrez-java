package org.citadel.controllers.local;

import org.citadel.models.Game;

public class LocalUserPlacementControllerBuilder extends LocalPlacementControllerBuilder {

    private Game game;

    public LocalUserPlacementControllerBuilder(Game game) {
        this.game = game;
    }
}
