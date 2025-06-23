package org.citadel.controllers.local;

import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.models.Game;

public class LocalContinueController extends LocalOperationController {

    public LocalContinueController(Game game) {
        super(game);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}
