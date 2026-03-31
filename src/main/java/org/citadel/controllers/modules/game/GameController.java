package org.citadel.controllers.modules.game;

import org.citadel.controllers.modules.game.local.logic.GameState;

public interface GameController extends OperationController {
    GameState getGameState();

    void startNewGame();

    void loadGame();

    void saveGame();

    void showHistory();

    void exitGame();

    boolean isGameInProgress();
}
