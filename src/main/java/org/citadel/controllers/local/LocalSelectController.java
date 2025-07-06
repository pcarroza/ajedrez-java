package org.citadel.controllers.local;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.models.Game;
import org.citadel.models.pieces.Coordinate;
import org.citadel.controllers.SelectController;

public class LocalSelectController extends LocalPlacementController implements SelectController {

    public LocalSelectController(Game game) {
        super(game);
    }

    @Override
    public void select(Coordinate coordinate) {
        assert coordinate != null;
        assert ValidatorLimitsBoard.getInstance().isWithinLimits(coordinate);
        super.select(coordinate);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
