package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.CastlingMovesController;
import org.citadel.controllers.modules.game.SpecialMovementsControllerVisitor;
import org.citadel.models.modules.game.Game;

import org.citadel.models.modules.game.pieces.Coordinate;

import java.util.Collections;
import java.util.List;

public class LocalCastlingMovesController extends LocalSpecialMovementsController implements CastlingMovesController {

    public LocalCastlingMovesController(Game game) {
        super(game);
    }

    @Override
    public boolean isApplicable() {
        return false;
    }

    @Override
    public List<Coordinate> getAvailableRooks() {
        return Collections.emptyList();
    }

    @Override
    public void castle(Coordinate rookCoordinate) {
        // TODO: Implementar lógica
    }

    @Override
    public void accept(SpecialMovementsControllerVisitor specialMovementsControllerVisitor) {
        specialMovementsControllerVisitor.visit(this);
    }
}
