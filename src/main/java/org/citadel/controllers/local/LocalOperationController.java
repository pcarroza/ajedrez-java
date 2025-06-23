package org.citadel.controllers.local;

import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.models.Game;

public abstract class LocalOperationController extends LocalController {
    LocalOperationController(Game game) {
        super(game);
    }

    public abstract void accept(OperationControllerVisitor operationControllerVisitor);
}
