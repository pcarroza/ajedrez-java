package org.citadel.views.console;

import org.citadel.controllers.modules.game.PlacementController;
import org.citadel.controllers.modules.game.PlacementControllerVisitor;
import org.citadel.controllers.modules.game.PutPieceController;
import org.citadel.controllers.modules.game.SelectPieceController;

public class GameView implements PlacementControllerVisitor {

    @Override
    public void visit(PutPieceController putPieceController) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(SelectPieceController selectPieceController) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void interact(PlacementController placementController) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interact'");
    }

}
