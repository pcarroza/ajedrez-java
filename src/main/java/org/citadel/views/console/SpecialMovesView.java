package org.citadel.views.console;

import org.citadel.controllers.local.LocalSpecialMovementsController;
import org.citadel.views.console.menus.SpecialMovesMenu;

import java.util.List;

public class SpecialMovesView {

    public void interact(List<LocalSpecialMovementsController> controllers) {
        assert controllers != null;
        new SpecialMovesMenu(controllers).execute();
    }
}