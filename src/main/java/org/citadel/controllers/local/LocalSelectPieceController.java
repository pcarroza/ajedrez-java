package org.citadel.controllers.local;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.controllers.PlacementControllerVisitor;
import org.citadel.controllers.SelectPieceController;
import org.citadel.models.Game;
import org.citadel.models.pieces.Coordinate;

import java.util.List;

public class LocalSelectPieceController extends LocalPlacementController implements SelectPieceController {

    private final LocalSpecialMovementsControllerFactory factory;

    public LocalSelectPieceController(Game game) {
        super(game);
        factory = new LocalSpecialMovementsControllerFactory(game);
    }

    public boolean hasSpecialMovements() {
        return factory.isApplicable();
    }

    @Override
    public void select(Coordinate coordinate) {
        assert coordinate != null;
        assert ValidatorLimitsBoard.getInstance().isWithinLimits(coordinate);
        super.select(coordinate);
    }

    @Override
    public List<LocalSpecialMovementsController> getSpecialMovements() {
        return factory.getApplicableControllers();
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void accept(PlacementControllerVisitor placementControllerVisitor) {
        placementControllerVisitor.visit(this);
    }
}
