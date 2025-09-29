package org.citadel.controllers.local;

import org.citadel.controllers.PromotionController;
import org.citadel.controllers.SpecialMovementsControllerVisitor;
import org.citadel.models.Game;

public class LocalPromotionController extends LocalSpecialMovementsController implements PromotionController {

    public LocalPromotionController(Game game) {
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
}
