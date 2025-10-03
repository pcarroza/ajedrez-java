package org.citadel.controllers.local;

import org.citadel.controllers.SpecialMovementsControllerVisitor;
import org.citadel.controllers.CastlingMovesController;
import org.citadel.models.Game;

import org.citadel.models.pieces.Coordinate;

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
    public void accept(SpecialMovementsControllerVisitor specialMovementsControllerVisitor) {
        specialMovementsControllerVisitor.visit(this);
    }

    @Override
    public List<Coordinate> getAvailableRooks() {
        return Collections.emptyList(); // TODO: Implementar lógica
    }

    @Override
    public void castle(Coordinate rookCoordinate) {
        // TODO: Implementar lógica
    }
}
