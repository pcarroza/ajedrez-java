package org.citadel.views.console;

import org.citadel.common.tools.Terminal;
import org.citadel.views.console.commands.Command;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    protected List<Command> commands;

    public Menu() {
        this.commands = new ArrayList<Command>();
    }

    protected abstract void setCommands();

    public void execute() {
        this.write();
        int option = this.getOption();
        commands.get(option).execute();
    }

    private void write() {
        Terminal.writeln("");
        Terminal.writeln("---------------------");
        for (int i = 0; i < commands.size(); i++) {
            Terminal.writeln((i + 1) + ". " + commands.get(i).getTitle());
        }
    }

    private int getOption() {
        int option;
        do {
            option = Terminal.readInt("Opción");
        } while (option < 1 || option > commands.size());
        return option - 1;
    }
}
