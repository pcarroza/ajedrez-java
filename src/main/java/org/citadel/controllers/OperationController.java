package org.citadel.controllers;

public interface OperationController {

    void accept(OperationControllerVisitor operationControllerVisitor);
}
