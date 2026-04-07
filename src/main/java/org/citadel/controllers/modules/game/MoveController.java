package org.citadel.controllers.modules.game;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.PromotionType;

public interface MoveController {
    void executeMove(Coordinate target);

    boolean isThePawnPromoted();

    void promote(PromotionType pieceType);
}
