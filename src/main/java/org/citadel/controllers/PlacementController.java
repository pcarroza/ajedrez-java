package org.citadel.controllers;

public interface PlacementController extends OperationController {

    void accept(PlacementControllerVisitor placementControllerVisitor);
}
