package org.citadel.controllers.modules.game;

public interface OperationController {

    void accept(OperationControllerVisitor operationControllerVisitor);
}
