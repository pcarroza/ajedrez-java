package org.citadel.controllers;

import org.citadel.controllers.local.LocalContinueController;
import org.citadel.controllers.local.LocalGameController;
import org.citadel.controllers.local.LocalPutPieceController;
import org.citadel.controllers.local.LocalSelectPieceController;
import org.citadel.controllers.local.LocalStartController;

public interface OperationControllerVisitor {

    void visit(LocalContinueController menuController);

    void visit(LocalStartController startController);

    void visit(LocalGameController gameController);

    void visit(LocalPutPieceController putPieceController);

    void visit(LocalSelectPieceController selectPieceController);
}