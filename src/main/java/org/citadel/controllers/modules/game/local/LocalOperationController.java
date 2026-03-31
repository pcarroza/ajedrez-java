package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.OperationController;
import org.citadel.controllers.modules.game.OperationControllerVisitor;
import org.citadel.models.Game;

public abstract class LocalOperationController extends LocalController implements OperationController {

    LocalOperationController(Game game) {
        super(game);
    }

    public abstract void accept(OperationControllerVisitor operationControllerVisitor);
}
