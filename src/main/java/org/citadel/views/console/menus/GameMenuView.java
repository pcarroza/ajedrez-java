import org.citadel.controllers.GameController;
import org.citadel.models.Game;
import org.citadel.views.console.commands.game.ExitCommand;
import org.citadel.views.console.commands.game.GameHistoryCommand;
import org.citadel.views.console.commands.game.InGameCommand;
import org.citadel.views.console.commands.game.LoadGameCommand;
import org.citadel.views.console.commands.game.SaveGameCommand;
import org.citadel.views.console.commands.game.ShowHistoryCommand;

public class GameMenuView extends Menu {

    public GameMenuView(GameController gameController) {
        super("MENÚ PRINCIPAL");
        add(new MenuItem("INICIAR NUEVA PARTIDA", new InGameCommand(gameController)));
        add(new MenuItem("CARGAR PARTIDA", new LoadGameCommand(gameController)));
        add(new MenuItem("GUARDAR PARTIDA", new SaveGameCommand(gameController)));
        add(new MenuItem("HISTORIAL DE PARTIDAS", new ShowHistoryCommand(gameController)));
        add(new MenuItem("HISTORIAL DE JUGADAS", new GameHistoryCommand(gameController)));
        add(new MenuItem("SALIR DE LA PARTIDA", new ExitCommand(gameController)));
    }
}
