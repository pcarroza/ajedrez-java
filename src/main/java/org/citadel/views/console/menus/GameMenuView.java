package org.citadel.views.console.menus;

import org.citadel.controllers.GameController;
import org.citadel.views.console.menus.commands.game.ExitCommand;
import org.citadel.views.console.menus.commands.game.InGameCommand;
import org.citadel.views.console.menus.commands.game.LoadGameCommand;
import org.citadel.views.console.menus.commands.game.SaveGameCommand;
import org.citadel.views.console.menus.commands.game.ShowHistoryCommand;

public class GameMenuView extends Menu {

    private final GameController gameController;

    public GameMenuView(GameController gameController) {
        this.gameController = gameController;
        this.setCommands();
    }

    @Override
    protected void setCommands() {
        commands.add(new InGameCommand("[1] INICIAR PARTIDA", gameController));
        commands.add(new LoadGameCommand("[2] CARGAR PARTIDA", gameController));
        commands.add(new SaveGameCommand("[3] GUARDAR PARTIDA", gameController));
        commands.add(new ShowHistoryCommand("[4] HISTORIAL DE PARTIDAS", gameController));
        commands.add(new ExitCommand("[5] SALIR DEL JUEGO", gameController));
    }
}
