package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.PromotionPawnController;
import org.citadel.controllers.modules.game.SpecialMovementsControllerVisitor;
import org.citadel.models.modules.game.Game;
import org.citadel.models.modules.game.pieces.enums.PromotionType;

public class LocalPromotionPawnController extends LocalSpecialMovementsController implements PromotionPawnController {

    public LocalPromotionPawnController(Game game) {
        super(game);
    }

    @Override
    public boolean isApplicable() {
        return game.isPawnSelected() && game.isThePawnPromoted();
    }

    @Override
    public void promote(PromotionType promotionType) {
        game.promote(promotionType);
        game.endTurn();
    }

    @Override
    public void accept(SpecialMovementsControllerVisitor specialMovementsControllerVisitor) {
        specialMovementsControllerVisitor.visit(this);
    }
}
