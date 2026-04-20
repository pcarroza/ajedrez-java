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
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }

    @Override
    public String getPieceSimbol(Coordinate coordinate) {
        throw new UnsupportedOperationException("Unimplemented method 'getPieceSimbol'");
    }

    @Override
    public void put(Coordinate target) {
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}
