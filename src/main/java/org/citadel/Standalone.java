package org.citadel;

import org.citadel.controllers.GameController;
import org.citadel.views.console.ConsoleView;

public class Standalone extends Chess {

    @Override
    public GameController getGameController() {
        return new LocalLogic();
    }

    @Override
    public View getView() {
        return new ConsoleView();
    }

    public static void main(String[] args) {
        new Standalone().run();
    }
}
