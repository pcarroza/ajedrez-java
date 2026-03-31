package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.PromotionPawnController;
import org.citadel.controllers.modules.game.SpecialMovementsControllerVisitor;
import org.citadel.models.Game;

public class LocalPromotionPawnController extends LocalSpecialMovementsController implements PromotionPawnController {

    public LocalPromotionPawnController(Game game) {
        super(game);
    }

    @Override
    public boolean isApplicable() {
        return false;
    }

    @Override
    public void promote(String pieceType) {
        // TODO: Implementar lógica
    }

    @Override
    public void accept(SpecialMovementsControllerVisitor specialMovementsControllerVisitor) {
        specialMovementsControllerVisitor.visit(this);
    }
}
