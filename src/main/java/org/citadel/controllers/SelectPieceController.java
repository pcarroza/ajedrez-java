package org.citadel.controllers;

import java.util.List;

import org.citadel.models.pieces.Coordinate;

public interface SelectPieceController extends PlacementController {

    boolean hasSpecialMovements();

    List<SpecialMovementsController> getSpecialMovements();

    void select(Coordinate coordinate);
}
