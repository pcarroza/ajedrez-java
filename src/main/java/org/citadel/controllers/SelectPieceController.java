package org.citadel.controllers;

import java.util.List;

import org.citadel.controllers.local.LocalSpecialMovementsController;
import org.citadel.models.pieces.Coordinate;

public interface SelectPieceController extends PlacementController {

    boolean hasSpecialMovements();

    List<LocalSpecialMovementsController> getSpecialMovements();

    void select(Coordinate coordinate);
}
