package org.citadel.controllers.local.logic;

import org.citadel.controllers.OperationController;
import org.citadel.controllers.local.LocalOperationControllerBuilder;

public class MenuState extends State {

    public MenuState(StatesBuilder statesBuilder, LocalOperationControllerBuilder controllerBuilder) {
        super(statesBuilder, controllerBuilder);
    }

    @Override
    public OperationController getController() {
        return controllerBuilder.getMenuController();
    }

    @Override
    public State initialize() {
        return statesBuilder.getInitialState();
    }
}
