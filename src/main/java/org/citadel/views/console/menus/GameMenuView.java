package org.citadel.views.console.menus;

import org.citadel.controllers.GameController;
import org.citadel.views.console.menus.commands.game.ExitCommand;
import org.citadel.views.console.menus.commands.game.InGameCommand;
import org.citadel.views.console.menus.commands.game.LoadGameCommand;
import org.citadel.views.console.menus.commands.game.SaveGameCommand;
import org.citadel.views.console.menus.commands.game.ShowHistoryCommand;

public class GameMenuView extends Menu {

    public GameMenuView(GameController gameController) {
        super("MENÚ PRINCIPAL");
        this.add(new InGameCommand("INICIAR PARTIDA", gameController));
        this.add(new LoadGameCommand("CARGAR PARTIDA", gameController));
        this.add(new SaveGameCommand("GUARDAR PARTIDA", gameController));
        this.add(new ShowHistoryCommand("HISTORIAL DE PARTIDAS", gameController));
        this.add(new ExitCommand("SALIR DEL JUEGO", gameController));
    }

    @Override
    public boolean isActive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isActive'");
    }
}
