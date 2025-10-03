package org.citadel.views.console;

import org.citadel.controllers.MenuController;
import org.citadel.views.console.commands.NewGameCommand;
import org.citadel.views.console.commands.LoadGameCommand;
import org.citadel.views.console.commands.SaveGameCommand;
import org.citadel.views.console.commands.ShowHistoryCommand;
import org.citadel.views.console.commands.ExitCommand;

public class MainMenuView extends Menu {

    private final MenuController menuController;

    public MainMenuView(MenuController menuController) {
        this.menuController = menuController;
        this.setCommands();
    }

    @Override
    protected void setCommands() {
        commands.add(new NewGameCommand("Iniciar Nuevo Juego", menuController));
        commands.add(new LoadGameCommand("Cargar Juego", menuController));
        commands.add(new SaveGameCommand("Guardar Juego", menuController));
        commands.add(new ShowHistoryCommand("Mostrar Historial", menuController));
        commands.add(new ExitCommand("Salir del Juego", menuController));
    }
}
