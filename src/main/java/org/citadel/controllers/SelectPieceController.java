package org.citadel.controllers;

import java.util.List;

import org.citadel.controllers.local.LocalSpecialMovementsController;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.enums.Player;

public interface SelectPieceController extends PlacementController {

    boolean hasSpecialMovements();

    List<LocalSpecialMovementsController> getSpecialMovements();

    void select(Coordinate coordinate);

    boolean isSelectPiece(Coordinate coordinate);

    Player getCurrentPlayer();
}
