package org.citadel;

import org.citadel.controllers.OperationController;
import org.citadel.controllers.OperationControllerVisitor;

public interface View extends OperationControllerVisitor {

    void interact(OperationController operationController);
}
