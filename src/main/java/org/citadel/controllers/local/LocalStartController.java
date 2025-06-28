package org.citadel.controllers.local;

import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.controllers.StartController;
import org.citadel.models.Game;

public abstract class LocalStartController extends LocalOperationController implements StartController {

    public LocalStartController(Game game) {
        super(game);
    }

    public void start() {
      // TODO document why this method is empty
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
