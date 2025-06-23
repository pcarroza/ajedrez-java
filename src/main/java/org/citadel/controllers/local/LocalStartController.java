package org.citadel.controllers.local;

import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.models.Game;

public class LocalStartController extends LocalOperationController {

    public LocalStartController(Game game) {
        super(game);
    }

    public void start() {
      // TODO document why this method is empty
    }

    @Override
    public void visit(OperationControllerVisitor operationControllerVisitor) {
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }
}
