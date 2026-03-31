package org.citadel.controllers.modules.game.local;

import java.util.List;

import org.citadel.controllers.modules.game.EnPassantPawnController;
import org.citadel.controllers.modules.game.SpecialMovementsControllerVisitor;
import org.citadel.models.modules.game.Game;
import org.citadel.models.modules.game.pieces.Coordinate;

public class LocalEnPassantPawnController extends LocalSpecialMovementsController implements EnPassantPawnController {

    public LocalEnPassantPawnController(Game game) {
        super(game);
    }

    @Override
    public boolean isApplicable() {
        if (!game.isPawnSelected()) {
            return false;
        }
        for (Coordinate diagonal : game.getSelectedPieceEnPassantDiagonals()) {
            Coordinate rivalPawnCoord = new Coordinate(game.getSelectedPieceCoordinate().row(), diagonal.column());
            if (game.isVulnerablePawnAt(rivalPawnCoord)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void capture() {
        for (Coordinate diagonal : game.getSelectedPieceEnPassantDiagonals()) {
            Coordinate rivalPawnCoord = new Coordinate(game.getSelectedPieceCoordinate().row(), diagonal.column());
            if (game.isVulnerablePawnAt(rivalPawnCoord)) {
                game.removeRivalPlayerPiece(rivalPawnCoord);
                game.putPiece(diagonal);
                game.switchTurn();
                return;
            }
        }
    }

    @Override
    public void accept(SpecialMovementsControllerVisitor specialMovementsControllerVisitor) {
        specialMovementsControllerVisitor.visit(this);
    }
}
