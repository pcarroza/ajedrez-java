package org.citadel.views.console.menus;

import org.citadel.views.console.commands.Command;

public class MenuItem implements MenuComponent {

    private final String title;

    private final Command command;

    public MenuItem(String title, Command command) {
        this.title = title;
        this.command = command;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void execute() {
        this.command.execute();
    }

    @Override
    public boolean isActive() {
        return this.command.isActive();
    }
}
