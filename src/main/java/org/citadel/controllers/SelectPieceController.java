package org.citadel.controllers;

import org.citadel.models.pieces.Coordinate;

public interface SelectPieceController extends PlacementController {

    boolean hasSpecialMovements();

    void select(Coordinate coordinate);
}
