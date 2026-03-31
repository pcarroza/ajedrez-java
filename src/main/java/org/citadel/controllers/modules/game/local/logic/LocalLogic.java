package org.citadel.controllers.modules.game.local.logic;

import org.citadel.controllers.modules.game.local.LocalOperationControllerBuilder;
import org.citadel.controllers.modules.game.GameController;
import org.citadel.controllers.modules.game.OperationController;
import org.citadel.controllers.modules.game.OperationControllerVisitor;
import org.citadel.models.Game;

import java.util.HashMap;
import java.util.Map;

public class LocalLogic implements GameController {

    private final Game game;

    private final Map<GameState, OperationController> controllers;

    private GameState gameState;

    public LocalLogic() {
        game = new Game(null);
        controllers = new HashMap<>();
        LocalOperationControllerBuilder builder = new LocalOperationControllerBuilder(game);
        builder.build();
        controllers.put(GameState.INITIAL, builder.getStartController());
        controllers.put(GameState.IN_GAME, builder.getPlacementController());
        controllers.put(GameState.MENU, builder.getGameController());
        controllers.put(GameState.EXIT, builder.getContinueController());
        gameState = GameState.INITIAL;
    }

    @Override
    public GameState getGameState() {
        return gameState;
    }

    public void accept(OperationControllerVisitor visitor) {
        controllers.get(getGameState()).accept(visitor);
    }

    @Override
    public void startNewGame() {
        gameState = GameState.IN_GAME;
    }

    @Override
    public void loadGame() {
        // ...
    }

    @Override
    public void saveGame() {
        // ...
    }

    @Override
    public void showHistory() {
        // ...
    }

    @Override
    public void exitGame() {
        gameState = GameState.EXIT;
    }

    @Override
    public boolean isGameInProgress() {
        return gameState == GameState.IN_GAME;
    }
}