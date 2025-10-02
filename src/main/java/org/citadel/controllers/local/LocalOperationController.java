package org.citadel.controllers.local;

import org.citadel.controllers.OperationController;
import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.models.Game;

public abstract class LocalOperationController extends LocalController implements OperationController {

    LocalOperationController(Game game) {
        super(game);
    }

    public abstract void accept(OperationControllerVisitor operationControllerVisitor);
}
