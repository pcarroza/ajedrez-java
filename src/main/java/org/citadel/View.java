package org.citadel;

import org.citadel.controllers.modules.game.OperationController;
import org.citadel.controllers.modules.game.OperationControllerVisitor;

public interface View extends OperationControllerVisitor {

    void interact(OperationController operationController);
}
