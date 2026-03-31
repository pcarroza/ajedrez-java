package org.citadel.controllers;

import org.citadel.models.pieces.Coordinate;

public interface PlacementController extends OperationController {

    void accept(PlacementControllerVisitor placementControllerVisitor);

    String getPieceSimbol(Coordinate coordinate);
}

