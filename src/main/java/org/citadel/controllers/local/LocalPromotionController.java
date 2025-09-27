package org.citadel.controllers.local;

import org.citadel.models.Game;

public class LocalPromotionController extends LocalSpecialMovementsController {

    public LocalPromotionController(Game game) {
        super(game);
    }

    @Override
    public boolean isApplicable() {
        return false;
    }
}
