package org.citadel.views.console.menus;

import org.citadel.controllers.GameController;
import org.citadel.views.console.commands.game.BackCommand;
import org.citadel.views.console.commands.game.GameHistoryCommand;
import org.citadel.views.console.commands.game.ShowHistoryCommand;

public class HistoryMenuView extends Menu {

    public HistoryMenuView(GameController gameController, MenuContext context) {
        super("MENÚ PRINCIPAL");
        add(new MenuItem("HISTORIAL DE PARTIDAS", new ShowHistoryCommand(gameController)));
        add(new MenuItem("HISTORIAL DE JUGADAS", new GameHistoryCommand(gameController)));
        add(new MenuItem("VOLVER", new BackCommand(context)));
    }
}
