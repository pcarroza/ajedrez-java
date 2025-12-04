package org.citadel.controllers.local;

import org.citadel.models.Game;

public abstract class LocalPlacementController extends LocalOperationController {

    LocalPlacementController(Game game) {
        super(game);
    }
}
