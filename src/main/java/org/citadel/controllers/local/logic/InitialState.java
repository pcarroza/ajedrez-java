package org.citadel.controllers.local.logic;

import org.citadel.controllers.local.LocalOperationController;
import org.citadel.controllers.local.LocalOperationControllerBuilder;
import org.citadel.controllers.local.LocalStartController;

public class InitialState extends State {

    private final LocalStartController localStartController;

    public InitialState(StatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        localStartController = builder.getStartController();
    }

    @Override
    State begin() {
        return statesBuilder.getInGameState();
    }

    @Override
    LocalOperationController getController() {
        return localStartController;
    }
}
