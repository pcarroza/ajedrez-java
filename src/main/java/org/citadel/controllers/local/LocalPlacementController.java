package org.citadel.controllers.local;

import org.citadel.models.Game;
import org.citadel.models.pieces.Coordinate;

public abstract class LocalPlacementController extends LocalOperationController {

    LocalPlacementController(Game game) {
        super(game);
    }

    @Override
    public String getPieceChar(Coordinate coordinate) {
        return super.getPieceChar(coordinate);
    }
}
