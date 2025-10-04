package org.citadel.views.console;

import org.citadel.controllers.SpecialMovementsController;
import org.citadel.views.console.menus.SpecialMovesMenu;

import java.util.List;

public class SpecialMovesView {

    public void interact(List<SpecialMovementsController> controllers) {
        assert controllers != null;
        new SpecialMovesMenu(controllers).execute();
    }
}