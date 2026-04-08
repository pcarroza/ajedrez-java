package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.CastlingMovesController;
import org.citadel.controllers.modules.game.SpecialMovementsControllerVisitor;
import org.citadel.models.modules.game.Game;

import org.citadel.models.modules.game.pieces.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class LocalCastlingMovesController extends LocalSpecialMovementsController implements CastlingMovesController {

    public LocalCastlingMovesController(Game game) {
        super(game);
    }

    @Override
    public boolean isApplicable() {
        return game.isKingSelected() && !getAvailableRooks().isEmpty();
    }

    @Override
    public List<Coordinate> getAvailableRooks() {
        List<Coordinate> rooks = new ArrayList<>();
        if (!game.isKingSelected()) {
            return rooks;
        }
        return rooks;
    }

    @Override
    public void castle(Coordinate rookCoordinate) {
        Coordinate kingOldCoord = game.getSelectedPieceCoordinate();
        int row = kingOldCoord.row();
        int kingNewCol = (rookCoordinate.column() == 1) ? 2 : 7;
        int rookNewCol = (rookCoordinate.column() == 1) ? 3 : 6;

        game.relocate(rookCoordinate, new Coordinate(row, rookNewCol));
        game.putPiece(new Coordinate(row, kingNewCol));
        game.endTurn();
    }

    @Override
    public void accept(SpecialMovementsControllerVisitor specialMovementsControllerVisitor) {
        specialMovementsControllerVisitor.visit(this);
    }
}
