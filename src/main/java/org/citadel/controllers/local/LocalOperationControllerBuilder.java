package org.citadel.controllers.local;

import org.citadel.models.Game;

public class LocalOperationControllerBuilder {

    private LocalStartController localStartController;

    private LocalPlacementControllerBuilder[] builders;

    private LocalContinueController localContinueController;

    private Game game;

    public LocalOperationControllerBuilder(Game game) {
        this.game = game;
    }

    public void build() {
        localStartController = new LocalStartController(game, this);
        builders = new LocalPlacementControllerBuilder[game.getNumberPlayers()];
        localContinueController = new LocalContinueController(game);
    }

    public void build(int numberPlayers) {
        for (int i = 0; i < game.getNumberPlayers(); i++) {
            if (i < numberPlayers) {
                builders[i] = new LocalUserPlacementControllerBuilder(game);
            } else {
                builders[i] = new LocalRandomCoordinateControllerBuilder(game);
            }
            builders[i].buildPlacementController();
        }
    }

    public LocalContinueController getContinueController() {
        return localContinueController;
    }

    public LocalStartController getStartController() {
        return localStartController;
    }
}
