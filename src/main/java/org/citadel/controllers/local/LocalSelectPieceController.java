package org.citadel.controllers.local;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.controllers.PlacementControllerVisitor;
import org.citadel.controllers.SelectPieceController;
import org.citadel.models.Game;
import org.citadel.models.pieces.Coordinate;
import org.citadel.views.console.ConsoleView;

import java.util.List;

public class LocalSelectPieceController extends LocalPlacementController implements SelectPieceController {

    private final LocalSpecialMovementsControllerFactory factory;

    public LocalSelectPieceController(Game game) {
        super(game);
        this.factory = new LocalSpecialMovementsControllerFactory(game);
    }

    @Override
    public void select(Coordinate coordinate) {
        assert coordinate != null;
        assert ValidatorLimitsBoard.getInstance().isWithinLimits(coordinate);
        super.select(coordinate);
    }

    public List<LocalSpecialMovementsController> getSpecialMoveControllers() {
        return factory.getApplicableControllers();
    }

    public boolean hasSpecialMovements() {
        return factory.isApplicable();
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void accept(PlacementControllerVisitor placementControllerVisitor) {
        placementControllerVisitor.visit(this);
    }

    @Override
    public void accept(ConsoleView consoleView) {
        consoleView.visit(this);
    }
}
