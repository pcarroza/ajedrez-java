package org.citadel.views.console.menus;

import org.citadel.controllers.modules.game.GameController;
import org.citadel.views.console.commands.game.ExitCommand;
import org.citadel.views.console.commands.game.OpenMenuCommand;

public class StartMenuView extends Menu {

    public StartMenuView(GameController gameController, MenuContext context) {
        super("MENÚ DE INICIO");
        this.add(
                new MenuItem("INICIAR JUEGO", new OpenMenuCommand(context, new GameMenuView(gameController, context))));
        this.add(new MenuItem("SALIR DEL JUEGO", new ExitCommand(context)));
    }
}