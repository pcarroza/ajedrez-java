package org.citadel.controllers.modules.game.local;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.controllers.modules.game.OperationControllerVisitor;
import org.citadel.controllers.modules.game.PlacementControllerVisitor;
import org.citadel.controllers.modules.game.PutPieceController;
import org.citadel.models.modules.game.Game;
import org.citadel.models.modules.game.pieces.Coordinate;

public class LocalPutPieceController extends LocalPlacementController implements PutPieceController {

    public LocalPutPieceController(Game game) {
        super(game);
    }

    @Override
    public void put(Coordinate coordinate) {
        assert coordinate != null;
        assert ValidatorLimitsBoard.getInstance().isWithinLimits(coordinate);
        super.put(coordinate);
    }

    @Override
    public boolean isMovementValid(Coordinate coordinate) {
        return super.isMovementValid(coordinate);
    }

    @Override
    public void accept(PlacementControllerVisitor placementControllerVisitor) {
        placementControllerVisitor.visit(this);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
