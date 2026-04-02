package org.citadel;

import org.citadel.controllers.modules.game.GameController;

public class Standalone extends Chess {

    @Override
    public GameController getGameController() {
        return null;
    }

    @Override
    public View getView() {
        return null;
    }

    public static void main(String[] args) {
        new Standalone().run();
    }
}
