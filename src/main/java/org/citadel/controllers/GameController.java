package org.citadel.controllers;

import org.citadel.controllers.local.logic.GameState;

public interface GameController extends OperationController {
    GameState getGameState();
}
