package org.citadel.controllers.modules.game.local;

import org.citadel.models.Game;
import org.citadel.models.pieces.Coordinate;

public abstract class LocalPlacementController extends LocalOperationController {

    LocalPlacementController(Game game) {
        super(game);
    }

    @Override
    public String getPieceSimbol(Coordinate coordinate) {
        return super.getPieceSimbol(coordinate);
    }
}
