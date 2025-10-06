package org.citadel.views.console.menus;

import org.citadel.controllers.GameController;
import org.citadel.views.console.commands.game.*;

public class GameMenuView extends Menu {

    public GameMenuView(GameController gameController, MenuContext context) {
        super("MENÚ PRINCIPAL");
        Menu historyMenu = new Menu("OPCIONES DE HISTORIAL");
        historyMenu.setParent(this);
        historyMenu.add(new MenuItem("HISTORIAL DE PARTIDAS", new ShowHistoryCommand(gameController)));
        historyMenu.add(new MenuItem("HISTORIAL DE JUGADAS", new GameHistoryCommand(gameController)));
        historyMenu.add(new MenuItem("VOLVER", new BackCommand(context))); // <- El comando para volver
        add(new MenuItem("INICIAR NUEVA PARTIDA", new InGameCommand(gameController)));
        add(new MenuItem("CARGAR PARTIDA", new LoadGameCommand(gameController)));
        add(new MenuItem("GUARDAR PARTIDA", new SaveGameCommand(gameController)));
        add(new MenuItem("HISTORIAL...", new OpenMenuCommand(context, historyMenu))); // <- Abre el submenú
        add(new MenuItem("SALIR DE LA PARTIDA", new ExitCommand(gameController)));
    }
}