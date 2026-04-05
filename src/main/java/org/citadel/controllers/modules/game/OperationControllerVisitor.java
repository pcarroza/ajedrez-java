package org.citadel.controllers.modules.game;

import org.citadel.controllers.modules.game.local.LocalContinueController;
import org.citadel.controllers.modules.game.local.LocalGameController;
import org.citadel.controllers.modules.game.local.LocalPutPieceController;
import org.citadel.controllers.modules.game.local.LocalSelectPieceController;
import org.citadel.controllers.modules.game.local.LocalStartController;

public interface OperationControllerVisitor {

    void visit(LocalContinueController menuController);

    void visit(LocalStartController startController);

    void visit(LocalGameController gameController);

    void visit(LocalPutPieceController putPieceController);

    void visit(LocalSelectPieceController selectPieceController);
}