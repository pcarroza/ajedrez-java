package org.citadel.controllers.local;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.models.Game;
import org.citadel.models.pieces.Coordinate;

public class LocalPutPieceController extends LocalPlacementController {

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
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}
