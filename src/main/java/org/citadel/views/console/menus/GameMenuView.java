import org.citadel.controllers.GameController;
import org.citadel.views.console.commands.game.ExitCommand;
import org.citadel.views.console.commands.game.InGameCommand;
import org.citadel.views.console.commands.game.LoadGameCommand;
import org.citadel.views.console.commands.game.SaveGameCommand;
import org.citadel.views.console.commands.game.ShowHistoryCommand;

public class GameMenuView extends Menu {

    public GameMenuView(GameController gameController) {
        super("MENÚ PRINCIPAL");
        this.add(new MenuItem("INICIAR PARTIDA", new InGameCommand(gameController)));
        this.add(new MenuItem("CARGAR PARTIDA", new LoadGameCommand(gameController)));
        this.add(new MenuItem("GUARDAR PARTIDA", new SaveGameCommand(gameController)));
        this.add(new MenuItem("HISTORIAL DE PARTIDAS", new ShowHistoryCommand(gameController)));
        this.add(new MenuItem("SALIR DEL JUEGO", new ExitCommand(gameController)));
    }
}
