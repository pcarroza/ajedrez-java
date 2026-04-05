package org.citadel.controllers.modules.game;

import org.citadel.models.modules.game.pieces.Coordinate;

public interface PlacementController extends OperationController {

    void accept(PlacementControllerVisitor placementControllerVisitor);

    String getPieceSimbol(Coordinate coordinate);
}

