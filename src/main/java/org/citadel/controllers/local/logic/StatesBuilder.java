package org.citadel.controllers.local.logic;

import org.citadel.controllers.local.LocalOperationControllerBuilder;

public class StatesBuilder {

    private final MenuState menuState;

    private final InitialState initialState;

    private final InGameState inGameState;

    private final EndState finalState;

    private final ExitState exitState;

    public StatesBuilder(LocalOperationControllerBuilder builder) {
        menuState = new MenuState(this, builder);
        initialState = new InitialState(this, builder);
        inGameState = new InGameState(this, builder);
        finalState = new EndState(this, builder);
        exitState = new ExitState(this);
    }

    MenuState getMenuState() {
        return menuState;
    }

    State getInitialState() {
        return menuState;
    }

    InGameState getInGameState() {
        return inGameState;
    }

    EndState getEndState() {
        return finalState;
    }

    ExitState getExistState() {
        return exitState;
    }
}
