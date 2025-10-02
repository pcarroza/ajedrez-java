package org.citadel.controllers.local.logic;

import org.citadel.controllers.local.LocalOperationController;
import org.citadel.controllers.local.LocalOperationControllerBuilder;

public abstract class State {

    private LocalOperationControllerBuilder builder;

    State(LocalOperationControllerBuilder builder) {
        this.builder = builder;
    }

    State initialize() {
        assert false;
        return null;
    }

    State begin() {
        assert false;
        return null;
    }

    State end() {
        assert false;
        return null;
    }

    State exit() {
        assert false;
        return null;
    }

    abstract LocalOperationController getController();
}
