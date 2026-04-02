package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.OperationControllerVisitor;
import org.citadel.controllers.modules.game.PlacementControllerVisitor;
import org.citadel.controllers.modules.game.PutPieceController;
import org.citadel.models.modules.game.Game;
import org.citadel.models.modules.game.pieces.Coordinate;

public class LocalPutPieceController extends LocalPlacementController implements PutPieceController {

    LocalPutPieceController(Game game) {
        super(game);
    }

    @Override
    public void accept(PlacementControllerVisitor placementControllerVisitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }

    @Override
    public String getPieceSimbol(Coordinate coordinate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPieceSimbol'");
    }

    @Override
    public void put(Coordinate target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}
