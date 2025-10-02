package org.citadel.controllers.local.logic;

import org.citadel.controllers.local.LocalOperationController;
import org.citadel.controllers.local.LocalOperationControllerBuilder;

public class InGameState extends State {

    private final LocalOperationControllerBuilder builder;

    public InGameState(StatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.builder = builder;
    }

    @Override
    State end() {
        return statesBuilder.getEndState();
    }

    @Override
    LocalOperationController getController() {
        return builder.getPlacementController();
    }
}
