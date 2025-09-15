package org.citadel.controllers.local;

import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.models.Game;

public class LocalSpecialMovementsController extends LocalPlacementController {

    public LocalSpecialMovementsController(Game game) {
        super(game);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}