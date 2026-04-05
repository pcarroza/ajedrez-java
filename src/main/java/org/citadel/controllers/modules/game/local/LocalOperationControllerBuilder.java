package org.citadel.controllers.modules.game.local;

import org.citadel.models.modules.game.Game;

public class LocalOperationControllerBuilder {

    private LocalStartController localStartController;

    private LocalGameController localGameController;

    private LocalPlacementControllerBuilder[] builders;

    private LocalContinueController localContinueController;

    private final Game game;

    public LocalOperationControllerBuilder(Game game) {
        this.game = game;
    }

    public void build() {
        localStartController = new LocalStartController(game, this);
        builders = new LocalPlacementControllerBuilder[Game.NUMBER_PLAYERS];
        localContinueController = new LocalContinueController(game);
    }

    public void build(int numberPlayers) {
        for (int i = 0; i < Game.NUMBER_PLAYERS; i++) {
            if (i < numberPlayers) {
                builders[i] = new LocalUserPlacementControllerBuilder(game);
            } else {
                builders[i] = new LocalRandomCoordinateControllerBuilder(game);
            }
            builders[i].buildPlacementController();
        }
    }

    public LocalPlacementController getPlacementController() {
        return builders[game.getIndexCurrentPlayer()].getPlacementController();
    }

    public LocalContinueController getContinueController() {
        return localContinueController;
    }

    public LocalStartController getStartController() {
        return localStartController;
    }

    public LocalGameController getGameController() {
        return localGameController;
    }
}
