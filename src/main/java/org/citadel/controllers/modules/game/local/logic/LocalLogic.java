package org.citadel.controllers.modules.game.local.logic;

import org.citadel.controllers.modules.game.local.LocalOperationControllerBuilder;
import org.citadel.controllers.modules.game.OperationController;
import org.citadel.models.modules.game.Game;

import java.util.HashMap;
import java.util.Map;

public class LocalLogic {

    private final Game game;

    private final Map<GameState, OperationController> controllers;

    public LocalLogic() {
        game = new Game(null);
        controllers = new HashMap<>();
        LocalOperationControllerBuilder builder = new LocalOperationControllerBuilder(game);
        builder.build();
        controllers.put(GameState.INITIAL, builder.getStartController());
        controllers.put(GameState.IN_GAME, builder.getPlacementController());
        controllers.put(GameState.EXIT, builder.getContinueController());
    }

}