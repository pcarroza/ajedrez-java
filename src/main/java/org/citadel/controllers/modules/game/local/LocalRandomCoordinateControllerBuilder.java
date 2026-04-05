package org.citadel.controllers.modules.game.local;

import org.citadel.models.modules.game.Game;

public class LocalRandomCoordinateControllerBuilder extends LocalPlacementControllerBuilder {

    private Game game;

    LocalRandomCoordinateControllerBuilder(Game game) {
        this.game = game;
    }
}
