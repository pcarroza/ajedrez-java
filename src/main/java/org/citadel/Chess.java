package org.citadel;

import org.citadel.controllers.modules.game.GameController;
import org.citadel.controllers.modules.game.local.logic.GameState;

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
        do {
            view.interact(logic);
        } while (logic.getGameState() != GameState.EXIT);
    }
}
