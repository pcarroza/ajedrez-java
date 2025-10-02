package org.citadel.controllers.local.logic;

import org.citadel.controllers.local.LocalOperationController;

public class ExitState extends State {

    public ExitState(StatesBuilder statesBuilder) {
        super(statesBuilder);
    }

    @Override
    LocalOperationController getController() {
        return null;
    }
}
