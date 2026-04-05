package org.citadel;

import org.citadel.controllers.modules.game.GameController;

public abstract class Chess {

    private final GameController logic;

    protected final View view;

    Chess() {
        this.logic = getGameController();
        this.view = getView();
    }

    public abstract GameController getGameController();

    public abstract View getView();

    public void run() {
    }
}
