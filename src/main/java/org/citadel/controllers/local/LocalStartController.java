package org.citadel.controllers.local;

import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.controllers.StartController;
import org.citadel.models.Game;

public class LocalStartController extends LocalOperationController implements StartController {

    private final LocalOperationControllerBuilder localOperationControllerBuilder;

    public LocalStartController(Game game, LocalOperationControllerBuilder builder) {
        super(game);
        localOperationControllerBuilder = builder;
    }

    @Override
    public void start(int players) {
        localOperationControllerBuilder.build(players);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
