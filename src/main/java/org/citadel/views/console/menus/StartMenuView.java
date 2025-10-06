package org.citadel.views.console.menus;

import org.citadel.controllers.GameController;
import org.citadel.views.console.commands.game.ExitCommand;
import org.citadel.views.console.commands.game.InGameCommand;

public class StartMenuView extends Menu {

    StartMenuView(GameController gameController) {
        super("MENÚ DE INICIO");
        this.add(new MenuItem("[1] INICIAR PARTIDA", new InGameCommand(gameController)));
        this.add(new MenuItem("[5] SALIR DEL JUEGO", new ExitCommand(gameController)));
    }
}
