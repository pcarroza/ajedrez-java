package org.citadel.controllers;

import org.citadel.controllers.local.LocalContinueController;

public interface OperationControllerVisitor {

    void visit(LocalContinueController startController);

}
