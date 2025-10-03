package org.citadel.controllers.local.logic;

import org.citadel.controllers.GameState;
import org.citadel.controllers.local.LocalOperationController;

public abstract class State {

    protected StatesBuilder statesBuilder;

    protected State(StatesBuilder statesBuilder) {
        this.statesBuilder = statesBuilder;
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

    abstract GameState getGameState();
}
