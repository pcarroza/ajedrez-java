package org.citadel;

import org.citadel.controllers.modules.game.GameController;

public abstract class Chess {

    protected final View view;

    Chess() {
        this.view = getView();
    }

    public abstract GameController getGameController();

    public abstract View getView();

    public void run() {
    }
}
