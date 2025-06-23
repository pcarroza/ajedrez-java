package org.citadel.views.console;

import org.citadel.controllers.StartController;

public class StartView {

    public void interact(StartController startController) {
        int players = 1;
        startController.start(players);
    }
}
