package org.citadel.controllers.local.logic;

import org.citadel.controllers.OperationController;
import org.citadel.controllers.local.LocalOperationController;
import org.citadel.controllers.local.LocalOperationControllerBuilder;

public class MenuState extends State {

    private final LocalOperationControllerBuilder builder;

    public MenuState(StatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.builder = builder;
    }

    @Override
    public LocalOperationController getController() {
        return builder.getMenuController();
    }

    @Override
    public State initialize() {
        return statesBuilder.getInitialState();
    }
}
