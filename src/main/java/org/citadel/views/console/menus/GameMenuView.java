package org.citadel.views.console.menus;

import org.citadel.controllers.GameController;
import org.citadel.views.console.commands.game.*;

public class GameMenuView extends Menu {

    public GameMenuView(GameController gameController, MenuContext menuContext) {
        super("MENÚ PRINCIPAL");
        add(new MenuItem("INICIAR NUEVA PARTIDA", new InGameCommand(gameController)));
        add(new MenuItem("CARGAR PARTIDA", new LoadGameCommand(gameController)));
        add(new MenuItem("GUARDAR PARTIDA", new SaveGameCommand(gameController)));
        add(new MenuItem("HISTORIAL",
                new OpenMenuCommand(menuContext, new HistoryMenuView(gameController, menuContext))));
        add(new MenuItem("SALIR DE LA PARTIDA", new ExitCommand(gameController)));
    }
}
