package org.citadel.controllers.local;

import org.citadel.models.Game;

public class LocalRandomCoordinateControllerBuilder extends LocalPlacementControllerBuilder {

    private Game game;

    LocalRandomCoordinateControllerBuilder(Game game) {
        this.game = game;
    }
}
