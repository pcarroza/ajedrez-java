package org.citadel.controllers.local;

import java.util.ArrayList;

import org.citadel.controllers.StartController;
import org.citadel.models.Game;

public class LocalOperationControllerBuilder {

    private LocalStartController localStartController;

    private LocalPlacementControllerBuilder[] builders;

    private LocalContinueController localContinueController;

    public LocalOperationControllerBuilder(Game game) {
        localStartController = new LocalStartController(game);
            
    }



}
