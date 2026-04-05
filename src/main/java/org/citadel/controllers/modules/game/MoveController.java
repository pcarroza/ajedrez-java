package org.citadel.controllers.modules.game;

import org.citadel.models.modules.game.pieces.Coordinate;

public interface MoveController {
    void executeMove(Coordinate target);

    boolean isThePawnPromoted();

    void promotePawn(String pieceType);
}
