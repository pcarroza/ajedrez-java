package org.citadel.controllers.local;

import org.citadel.models.Game;

public class LocalOperationControllerBuilder {

    private LocalStartController localStartController;

    private LocalMenuController localMenuController;

    private LocalPlacementControllerBuilder[] builders;

    private LocalContinueController localContinueController;

    private final Game game;

    public LocalOperationControllerBuilder(Game game) {
        this.game = game;
    }

    public void build() {
        localStartController = new LocalStartController(game, this);
        localMenuController = new LocalMenuController(game);
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

    public LocalMenuController getMenuController() {
        return localMenuController;
    }
}
