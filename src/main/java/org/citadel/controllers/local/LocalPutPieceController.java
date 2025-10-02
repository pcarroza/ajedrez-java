package org.citadel.controllers.local;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.controllers.PlacementControllerVisitor;
import org.citadel.controllers.PutPieceController;
import org.citadel.models.Game;
import org.citadel.models.pieces.Coordinate;

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
    public void accept(PlacementControllerVisitor placementControllerVisitor) {
        placementControllerVisitor.visit(this);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public boolean isMovementValid(Coordinate coordinate) {
        return super.isMovementValid(coordinate);
    }
}
