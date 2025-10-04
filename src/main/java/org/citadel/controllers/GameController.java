package org.citadel.controllers;

import org.citadel.controllers.local.logic.GameState;

public interface GameController extends OperationController {
    GameState getGameState();

    void startNewGame();

    void loadGame();

    void saveGame();

    void showHistory();

    void exitGame();
}
