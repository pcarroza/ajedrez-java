package org.citadel.views.console;

import org.citadel.views.console.commands.game.ExitCommand;
import org.citadel.views.console.commands.game.LoadGameCommand;
import org.citadel.views.console.commands.game.InGameCommand;
import org.citadel.views.console.commands.game.SaveGameCommand;
import org.citadel.views.console.commands.game.ShowHistoryCommand;
import org.citadel.controllers.GameController;

public class MainMenuView extends Menu {

    private final MenuController menuController;

    public MainMenuView(MenuController menuController) {
        this.menuController = menuController;
        this.setCommands();
    }

    @Override
    protected void setCommands() {
        commands.add(new InGameCommand("Iniciar Nuevo Juego", menuController));
        commands.add(new LoadGameCommand("Cargar Juego", menuController));
        commands.add(new SaveGameCommand("Guardar Juego", menuController));
        commands.add(new ShowHistoryCommand("Mostrar Historial", menuController));
        commands.add(new ExitCommand("Salir del Juego", menuController));
    }
}
