package org.citadel.controllers.modules.game;

import java.util.List;

import org.citadel.controllers.modules.game.local.LocalSpecialMovementsController;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.Player;

public interface SelectPieceController extends PlacementController {

    boolean hasSpecialMovements();

    List<LocalSpecialMovementsController> getSpecialMovements();

    void select(Coordinate coordinate);

    boolean isSelectPiece(Coordinate coordinate);

    Player getCurrentPlayer();
}
