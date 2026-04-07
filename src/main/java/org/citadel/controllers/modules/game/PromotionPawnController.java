package org.citadel.controllers.modules.game;

import org.citadel.models.modules.game.pieces.enums.PromotionType;

public interface PromotionPawnController extends SpecialMovementsController {

    void promote(PromotionType promotionType);
}
