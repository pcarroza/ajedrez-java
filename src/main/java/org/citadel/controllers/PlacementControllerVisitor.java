package org.citadel.controllers;

public interface PlacementControllerVisitor {

    void visit(PutPieceController putPieceController);

    void visit(SelectPieceController selectPieceController);

    void interact(PlacementController placementController);
}
