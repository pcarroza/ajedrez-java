package org.citadel.views.console.menus.commands;

import org.citadel.views.console.menus.MenuComponent;

public abstract class Command extends MenuComponent {

    protected Command(String title) {
        super(title);
    }

    public abstract void execute();

}
