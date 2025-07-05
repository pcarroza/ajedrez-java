package org.citadel.controllers;

public interface OperationControllerVisitor {

    void visit(StartController startController);

    void visit(ContinueController continueController);
}
