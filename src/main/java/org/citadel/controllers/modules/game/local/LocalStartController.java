package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.OperationControllerVisitor;
import org.citadel.controllers.modules.game.StartController;
import org.citadel.models.modules.game.Game;

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
