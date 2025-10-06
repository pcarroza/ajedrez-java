import org.citadel.controllers.GameController;
import org.citadel.views.console.commands.game.ExitCommand;
import org.citadel.views.console.commands.game.InGameCommand;
import org.citadel.views.console.commands.game.LoadGameCommand;
import org.citadel.views.console.commands.game.SaveGameCommand;
import org.citadel.views.console.commands.game.ShowHistoryCommand;

public class GameMenuView extends Menu {

    public GameMenuView(GameController gameController) {
        super("MENÚ PRINCIPAL");
        this.add(new MenuItem("[1] INICIAR PARTIDA", new InGameCommand(gameController)));
        this.add(new MenuItem("[2] CARGAR PARTIDA", new LoadGameCommand(gameController)));
        this.add(new MenuItem("[3] GUARDAR PARTIDA", new SaveGameCommand(gameController)));
        this.add(new MenuItem("[4] HISTORIAL DE PARTIDAS", new ShowHistoryCommand(gameController)));
        this.add(new MenuItem("[5] SALIR DEL JUEGO", new ExitCommand(gameController)));
    }
}
