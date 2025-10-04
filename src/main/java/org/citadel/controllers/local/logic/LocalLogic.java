package org.citadel.controllers.local.logic;

import org.citadel.controllers.GameController;
import org.citadel.controllers.OperationController;
import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.controllers.local.LocalOperationControllerBuilder;
import org.citadel.models.Game;

import java.util.HashMap;
import java.util.Map;

public class LocalLogic implements GameController {

    private final Game game;

    private final Map<GameState, OperationController> controllers;

    public LocalLogic() {
        game = new Game(null);
        controllers = new HashMap<>();
        LocalOperationControllerBuilder builder = new LocalOperationControllerBuilder(game);
        controllers.put(GameState.INITIAL, builder.getStartController());
        controllers.put(GameState.IN_GAME, builder.getPlacementController());
        controllers.put(GameState.MENU, builder.getGameController());
        controllers.put(GameState.EXIT, builder.getContinueController());
    }

    @Override
    public GameState getGameState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGameState'");
    }

    public void accept(OperationControllerVisitor visitor) {
        controllers.get(getGameState()).accept(visitor);
    }

    @Override
    public void startNewGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startNewGame'");
    }

    @Override
    public void loadGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadGame'");
    }

    @Override
    public void saveGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveGame'");
    }

    @Override
    public void showHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showHistory'");
    }

    @Override
    public void exitGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exitGame'");
    }
}
