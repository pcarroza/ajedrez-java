package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.OperationControllerVisitor;
import org.citadel.controllers.modules.game.PlacementControllerVisitor;
import org.citadel.controllers.modules.game.SelectPieceController;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.Game;

import java.util.List;

public class LocalSelectPieceController extends LocalPlacementController implements SelectPieceController {

    LocalSelectPieceController(Game game) {
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
    public boolean hasSpecialMovements() {
        throw new UnsupportedOperationException("Unimplemented method 'hasSpecialMovements'");
    }

    @Override
    public List<LocalSpecialMovementsController> getSpecialMovements() {
        throw new UnsupportedOperationException("Unimplemented method 'getSpecialMovements'");
    }

    @Override
    public void select(Coordinate coordinate) {
        throw new UnsupportedOperationException("Unimplemented method 'select'");
    }

    @Override
    public boolean isSelectPiece(Coordinate coordinate) {
        throw new UnsupportedOperationException("Unimplemented method 'isSelectPiece'");
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}
