package org.citadel.controllers.local.logic;

import org.citadel.controllers.local.LocalContinueController;
import org.citadel.controllers.local.LocalOperationController;
import org.citadel.controllers.local.LocalOperationControllerBuilder;

public class EndState extends State {

    private final LocalContinueController localContinueController;

    EndState(StatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        localContinueController = builder.getContinueController();
    }

    @Override
    State initialize() {
        return statesBuilder.getInitialState();
    }

    @Override
    State exit() {
        return statesBuilder.getExistState();
    }

    @Override
    LocalOperationController getController() {
        return localContinueController;
    }
}
