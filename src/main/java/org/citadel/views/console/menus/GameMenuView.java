package org.citadel.views.console.menus;

import org.citadel.controllers.GameController;
import org.citadel.views.console.commands.game.*;

public class GameMenuView extends Menu {

    public GameMenuView(GameController gameController, MenuContext context) {
        super("MENÚ PRINCIPAL");
        add(new MenuItem("INICIAR NUEVA PARTIDA", new InGameCommand(gameController)));
        add(new MenuItem("CARGAR PARTIDA", new LoadGameCommand(gameController)));
        add(new MenuItem("GUARDAR PARTIDA", new SaveGameCommand(gameController)));
        add(new MenuItem("HISTORIAL", new OpenMenuCommand(context, new HistoryMenuView(gameController, context))));
        add(new MenuItem("SALIR DE LA PARTIDA", new ExitCommand(gameController)));
    }
}
