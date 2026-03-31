package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.ContinueController;
import org.citadel.controllers.modules.game.OperationControllerVisitor;
import org.citadel.models.modules.game.Game;

public class LocalContinueController extends LocalOperationController implements ContinueController {

    public LocalContinueController(Game game) {
        super(game);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
