package org.citadel.controllers.local.logic;

import org.citadel.controllers.local.LocalOperationController;
import org.citadel.controllers.local.LocalOperationControllerBuilder;

public class InGameState extends State {

    InGameState(StatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(builder);
    }

    @Override
    LocalOperationController getController() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getController'");
    }
}
