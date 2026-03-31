package org.citadel.controllers.modules.game;

import org.citadel.models.pieces.Coordinate;

public interface PutPieceController extends PlacementController {

    void put(Coordinate target);

    boolean isMovementValid(Coordinate coordinate);
}
