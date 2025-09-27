package org.citadel.controllers.local;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.models.Game;
import org.citadel.models.pieces.Coordinate;
import org.citadel.views.console.ConsoleView;
import org.citadel.controllers.SelectPieceController;

import java.util.List;

public class LocalSelectPieceController extends LocalPlacementController implements SelectPieceController {

    private final LocalSpecialMovementsControllerComposite specialMovementsComposite;

    private boolean hasSpecialMovements;

    public LocalSelectPieceController(Game game) {
        super(game);
        this.specialMovementsComposite = new LocalSpecialMovementsControllerComposite(game);
    }

    @Override
    public void select(Coordinate coordinate) {
        assert coordinate != null;
        assert ValidatorLimitsBoard.getInstance().isWithinLimits(coordinate);
        super.select(coordinate);
        this.hasSpecialMovements = specialMovementsComposite.isApplicable();
    }

    public List<LocalSpecialMovementsController> getSpecialMoveControllers() {
        return specialMovementsComposite.getApplicableControllers();
    }

    public boolean hasSpecialMovements() {
        return hasSpecialMovements;
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void accept(ConsoleView consoleView) {
        consoleView.visit(this);
    }
}
