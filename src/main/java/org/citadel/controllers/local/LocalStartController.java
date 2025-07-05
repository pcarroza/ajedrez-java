package org.citadel.controllers.local;

import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.controllers.StartController;
import org.citadel.models.Game;

public class LocalStartController extends LocalOperationController implements StartController {

    public LocalStartController(Game game) {
        super(game);
    }

    @Override
    public void start(int players) {
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
