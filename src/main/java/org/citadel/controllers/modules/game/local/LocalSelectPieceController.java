package org.citadel.controllers.modules.game.local;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.controllers.modules.game.OperationControllerVisitor;
import org.citadel.controllers.modules.game.PlacementControllerVisitor;
import org.citadel.controllers.modules.game.SelectPieceController;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.Game;

import java.util.List;

import org.citadel.models.pieces.enums.Player;

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
    public boolean isSelectPiece(Coordinate coordinate) {
        if (super.getCurrentPlayer() == Player.WHITE) {
            return super.isTheWhitePieceSelected(coordinate);
        }
        return super.isTheBlackPieceSelected(coordinate);
    }

    @Override
    public Player getCurrentPlayer() {
        return super.getCurrentPlayer();
    }

    @Override
    public void accept(PlacementControllerVisitor placementControllerVisitor) {
        placementControllerVisitor.visit(this);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }

}
