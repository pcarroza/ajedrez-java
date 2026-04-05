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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }

    @Override
    public String getPieceSimbol(Coordinate coordinate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPieceSimbol'");
    }

    @Override
    public boolean hasSpecialMovements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasSpecialMovements'");
    }

    @Override
    public List<LocalSpecialMovementsController> getSpecialMovements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSpecialMovements'");
    }

    @Override
    public void select(Coordinate coordinate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'select'");
    }

    @Override
    public boolean isSelectPiece(Coordinate coordinate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isSelectPiece'");
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }

}
